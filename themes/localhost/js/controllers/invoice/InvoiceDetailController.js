MetronicApp.controller('InvoiceDetailController', ['$rootScope', '$scope', 'InvoiceService', 'CustomerService', '$stateParams', '$state', '$modal', function ($rootScope, $scope, InvoiceService, CustomerService, $stateParams, $state, $modal, $filter) {
    $scope.newItem = {};

    $scope.invoiceId = $stateParams.invoiceId;
    InvoiceService.getById($scope.invoiceId);
    InvoiceService.searchItems('', $scope.invoiceId);

    if (!$scope.initialized) {
        $rootScope.$on('InvoiceService.getById', function (event, data) {
            $scope.invoice = data.result;

            if($scope.invoice.customerId) {
                CustomerService.getById($scope.invoice.customerId)
            }
        });

        $rootScope.$on('CustomerService.getById', function (event, data) {
            $scope.invoice.customer = data.result;
            $scope.invoice.customer.id = $scope.invoice.customerId;
        });

        $rootScope.$on('InvoiceItemService.search', function (event, data) {
            $scope.items = data.result;
        });


        $rootScope.$on('InvoiceService.addInvoiceItem', function (event, data) {
            $scope.doSearch();
            $scope.initialData();
            $rootScope.$emit('page.alert', {message:'اقلام فاکتور جدید در سیستم ثبت شد', type:"success"});
        });

        $rootScope.$on('InvoiceService.deleteInvoiceItem', function (event, data) {
            $scope.doSearch();
            $rootScope.$emit('page.alert', {message:'اقلام فاکتور انتخاب شده از سیستم حذف شد', type:"success"});
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

    $scope.goInvoiceList = function () {
        $state.go('invoices');
    };

    $scope.submitInvoice = function () {
        if ($scope.invoice.customer) {
            $scope.invoice.customerId = $scope.invoice.customer.id;
        }

        InvoiceService.updateInvoice($scope.invoice);
    };

    $scope.showTotalCost = function() {
        var result = 0;

        angular.forEach($scope.items, function (item) {
            result += item.number * item.basePrice;
        });

        return result;
    };

    $scope.doSearch = function () {
        InvoiceService.searchItems($scope.query || '', $scope.invoiceId);
    }

    $scope.submitInvoiceItem = function () {
        InvoiceService.addInvoiceItem($scope.newItem);
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
            InvoiceService.deleteInvoiceItem(itemId);
        }, function () {
            //$log.info('Modal dismissed at: ' + new Date());
        });
    };

    $scope.initialized = true;
}]);