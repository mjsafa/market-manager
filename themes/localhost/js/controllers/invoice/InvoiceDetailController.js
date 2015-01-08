MetronicApp.controller('InvoiceDetailController', ['$rootScope', '$scope', 'InvoiceService', 'CustomerService', '$stateParams', '$state', '$modal', function ($rootScope, $scope, InvoiceService, CustomerService, $stateParams, $state, $modal, $filter) {

    $scope.invoiceId = $stateParams.invoiceId;
    $scope.invoice = InvoiceService.getById($scope.invoiceId);

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
    }

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


}]);