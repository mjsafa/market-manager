MetronicApp.controller('InvoicesController', ['$rootScope', '$scope', 'InvoiceService', 'CustomerService', '$state', '$modal', function ($rootScope, $scope, InvoiceService, CustomerService, $state, $modal) {
    $rootScope.settings.layout.pageBodySolid = true;
    $rootScope.settings.layout.pageSidebarClosed = false;

    $scope.invoiceService = InvoiceService;
    $scope.currentCustomerId = onlineUser.customerId;
    $scope.searchCustomerId = $scope.currentCustomerId ? $scope.currentCustomerId:0;

    $scope.$on('$viewContentLoaded', function () {
        // initialize core components
        Metronic.initAjax();
    });

    if (!$scope.initialized) {
        $scope.$on('InvoiceService.addInvoice', function (event, data) {
            $scope.doSearch();
            $scope.initialData();
            $rootScope.$emit('page.alert', {message:'فاکتور جدید در سیستم ثبت شد', type:"success"});
            $scope.invoice_form.$setPristine();
        });

        $scope.$on('InvoiceService.search', function (event, data) {
            $scope.invoices = data.result.result;
            $scope.totalInvoices = data.result.total;

            if($scope.currentCustomerId) {
                CustomerService.getById($scope.currentCustomerId);
            }
        });

        $scope.$on('InvoiceService.updateInvoiceStatus', function (event, data) {
            $scope.doSearch();
            $rootScope.$emit('page.alert', {message:'بروز رسانی وضعیت فاکتور به درستی انجام شد.', type:"success"});
        });

        $rootScope.$on('CustomerService.getById', function (event, data) {
            $scope.currentCustomer = data.result;
            $scope.newInvoice.mobile = $scope.currentCustomer.mobile;
        });

        $scope.filter = $scope.filter || {};
        $scope.filter.currentPage = 1;
        $scope.itemsPerPage = 10;
    }

    $scope.initialData = function () {
        $scope.newInvoice = {
            customer: {},
            invoiceItems: [],
            typeOfDelivery: 1
        };
    };

    $scope.initialData();

    $scope.statuses = [
        {value:1, text:'در دست بررسی'},
        {value:0, text:'تایید شده'},
        {value:10001, text:'بسته شده'},
        {value:4, text:'رد شده'}
    ];

    $scope.getName = function (input, data, param) {
        var result = 'none';

        angular.forEach(data, function (object) {
            if (object.value == input) {
                result = object[param];
            }
        });

        return result;
    };

    $scope.showStatus = function (input) {
        return $scope.getName(input, $scope.statuses, 'text');
    };


    $scope.calculateTotalScore = function () {
        var totalScore = 0;
        angular.forEach($scope.newInvoice.invoiceItems, function(item){
            var number = 1;
            if(item.number){
                number = item.number;
            }
            if(item.product && item.product.score){
                totalScore += item.product.score * number;
            }
        });

        return totalScore;
    }

    $scope.submitInvoice = function () {
        if ($scope.newInvoice.customer) {
            $scope.newInvoice.customerId = $scope.newInvoice.customer.id;
        }

        if($scope.currentCustomerId) {
            $scope.newInvoice.customerId = $scope.currentCustomerId;
        }

        angular.forEach($scope.newInvoice.invoiceItems, function (item) {
            item.productId = item.product.id;
        });

        $scope.invoiceService.addInvoice($scope.newInvoice, {scope: $scope});
    };

    $scope.open = function (size) {
        var modalInstance = $modal.open({
            templateUrl:'myModalContent.html',
            controller:'CustomerSelectController',
            size:size,
            resolve:{
                customers:function () {
                }
            }
        });

        $scope.modalInstance = modalInstance;

        modalInstance.result.then(function (selectedItem) {
            $scope.newInvoice.customer = selectedItem;
        }, function () {
            //$log.info('Modal dismissed at: ' + new Date());
        });
    };

    $scope.openProductPopup = function (invoiceItem, size) {
        var modalInstance = $modal.open({
            templateUrl:'productModalContent.html',
            controller:'ProductSelectController',
            size:size,
            resolve:{
                products:function () {
                }
            }
        });

        $scope.modalInstance = modalInstance;

        modalInstance.result.then(function (selectedItem) {
            invoiceItem.product = selectedItem;
        }, function () {
            //$log.info('Modal dismissed at: ' + new Date());
        });
    };


    $scope.addItem = function () {
        $scope.newInvoice.invoiceItems.push({});
    };

    $scope.deleteItem = function (index) {
        $scope.newInvoice.invoiceItems.splice(index, 1);
    };

    $scope.doSearch = function () {
        $scope.filter = $scope.filter || {};
        $scope.filter.first = ($scope.filter.currentPage -1) * $scope.itemsPerPage;
        $scope.filter.maxResults = $scope.itemsPerPage;

        $scope.invoiceService.search($scope.filter, $scope.query || '', $scope.selectedStatus || '',
            $scope.searchCustomerId, {scope: $scope});
    }
    $scope.doSearch();

    $scope.doSearchButton = function () {
        $scope.filter.currentPage = 1;
        $scope.doSearch();
    }

    $scope.updateStatus = function(invoiceId ,newStatus) {
        $scope.invoiceService.updateInvoiceStatus(invoiceId, newStatus, {scope: $scope});
    }

    $scope.initialized = true;
}]);