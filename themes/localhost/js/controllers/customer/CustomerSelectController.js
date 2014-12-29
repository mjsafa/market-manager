'use strict';

MetronicApp.controller('CustomerSelectController', ['$rootScope', '$scope', 'CustomerService', '$state', '$modal', '$modalInstance', function ($rootScope, $scope, CustomerService, $state, $modal, $modalInstance, customers) {

    $scope.customers = CustomerService.search('');
    $scope.customerService = CustomerService;

    $scope.doSearch = function () {
        $scope.customerService.search($scope.query);
    }

    $scope.ok = function (item) {
        $modalInstance.close(item);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
     };
}]);