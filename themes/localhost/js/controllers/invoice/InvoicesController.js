MetronicApp.controller('InvoicesController', ['$rootScope', '$scope', 'InvoiceService', '$state', '$modal', function ($rootScope, $scope, InvoiceService, $state, $modal) {
    $rootScope.settings.layout.pageBodySolid = true;
    $rootScope.settings.layout.pageSidebarClosed = false;

    $scope.invoiceService = InvoiceService;
    $scope.invoiceService.search('');

    $scope.$on('$viewContentLoaded', function () {
        // initialize core components
        Metronic.initAjax();
    });

    if (!$scope.initialized) {
        $rootScope.$on('InvoiceService.addInvoice', function (event, data) {
            $scope.doSearch();
            $scope.initialData();
            $state.go('invoices');
        });

        $rootScope.$on('InvoiceService.search', function (event, data) {
            $scope.invoices = data.result;
        });
    }

    $scope.initialData = function () {
        $scope.newInvoice = {
            customer: {},
            invoiceItems: [],
            typeOfDelivery: 1
        };
    };

    $scope.initialData();

    $scope.submitInvoice = function () {
        if ($scope.newInvoice.customer) {
            $scope.newInvoice.customerId = $scope.newInvoice.customer.id;
        }

        $scope.invoiceService.addInvoice($scope.newInvoice);
        $scope.newInvoice = {};
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

    $scope.addItem = function () {
        $scope.newInvoice.invoiceItems.push({});
    };

    $scope.deleteItem = function (index) {
        $scope.newInvoice.invoiceItems.splice(index, 1);
    };

    $scope.doSearch = function () {
        $scope.invoiceService.search($scope.query || '');
    }

    $scope.initialized = true;
}]);