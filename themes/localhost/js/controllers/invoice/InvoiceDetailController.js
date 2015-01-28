MetronicApp.controller('InvoiceDetailController', ['$rootScope', '$scope', 'InvoiceService', 'CustomerService', '$stateParams', '$state', '$modal', function ($rootScope, $scope, InvoiceService, CustomerService, $stateParams, $state, $modal, $filter) {
    $scope.newItem = {};

    $scope.invoiceId = $stateParams.invoiceId;
    $scope.currentCustomerId = onlineUser.customerId;
    InvoiceService.getById($scope.invoiceId, {scope: $scope});
    InvoiceService.searchItems('', $scope.invoiceId, {scope: $scope});

    if (!$scope.initialized) {
        $scope.$on('InvoiceService.getById', function (event, data) {
            $scope.invoice = data.result;

            if($scope.invoice.customerId) {
                CustomerService.getById($scope.invoice.customerId)
            }
        });

        $rootScope.$on('CustomerService.getById', function (event, data) {
            $scope.invoice.customer = data.result;
            $scope.invoice.customer.id = $scope.invoice.customerId;
        });

        $scope.$on('InvoiceItemService.search', function (event, data) {
            $scope.items = data.result;

            angular.forEach($scope.items, function (item) {
                item.product = JSON.parse(item.product);
            });

        });

        $scope.$on('InvoiceService.addInvoiceItem', function (event, data) {
            $scope.doSearch();
            $scope.initialData();
            $scope.invoice_item_form.$setPristine();
            $rootScope.$emit('page.alert', {message:'اقلام فاکتور جدید در سیستم ثبت شد', type:"success"});
        });

        $scope.$on('InvoiceService.deleteInvoiceItem', function (event, data) {
            $scope.doSearch();
            $rootScope.$emit('page.alert', {message:'اقلام فاکتور انتخاب شده از سیستم حذف شد', type:"success"});
        });

        $scope.$on('InvoiceService.updateInvoice', function (event, data) {
            $rootScope.$emit('page.alert', {message:'بروز رسانی فاکتور به درستی انجام شد', type:"success"});
        });
    }

    $scope.initialData = function () {
        $scope.newItem = {
            invoiceId: $scope.invoiceId
        };
    };

    $scope.initialData();

    $scope.types = [
        {value: 1, text: 'پستی'},
        {value: 2, text: 'حضوری'},
        {value: 3, text: 'پیک'}
    ];

    $scope.showType = function() {
        var result = 'none';

        angular.forEach($scope.types, function (type) {
            if(type.value == $scope.invoice.typeOfDelivery){
                result = type.text;
            }
        });

        return result;
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
            $scope.invoice.customer = selectedItem;
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


    $scope.goInvoiceList = function () {
        $state.go('invoices');
    };

    $scope.submitInvoice = function () {
        if ($scope.invoice.customer) {
            $scope.invoice.customerId = $scope.invoice.customer.id;
        }

        InvoiceService.updateInvoice($scope.invoice, {scope: $scope});
    };

    $scope.showTotalCost = function() {
        var result = 0;

        angular.forEach($scope.items, function (item) {
            result += item.number * item.product.basePrice;
        });

        return result;
    };

    $scope.doSearch = function () {
        InvoiceService.searchItems($scope.query || '', $scope.invoiceId, {scope: $scope});
    }

    $scope.submitInvoiceItem = function () {
        $scope.newItem.productId = $scope.newItem.product.id;

        InvoiceService.addInvoiceItem($scope.newItem, {scope: $scope});
    };

    $scope.deleteItem = function (itemId, size) {
        var modalInstance = $modal.open({
            templateUrl:'confirmDeleteItemModal.html',
            controller:'ConfirmDialogController',
            size:size,
            resolve:{}
        });

        $scope.modalInstance = modalInstance;

        modalInstance.result.then(function (selectedItem) {
            InvoiceService.deleteInvoiceItem(itemId, {scope: $scope});
        }, function () {
            //$log.info('Modal dismissed at: ' + new Date());
        });
    };

    $scope.initialized = true;
}]);