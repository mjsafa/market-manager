'use strict';

angular.module('MetronicApp').controller('CustomerSelectController', ['$rootScope', '$scope', 'CustomerService', '$state', '$modal', '$modalInstance', function ($rootScope, $scope, CustomerService, $state, $modal, $modalInstance, customers) {
    if (!$scope.initialized) {
        $scope.$on('CustomerService.search', function (event, data) {
            $scope.customers = data.result;
        });

        CustomerService.search('', 0,{scope: $scope});
    }


    $scope.customerService = CustomerService;

    $scope.doSearch = function () {
        $scope.customerService.search($scope.query, 0, {scope: $scope});
    }

    $scope.ok = function (item) {
        $modalInstance.close(item);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };

    $scope.initialized = true;
}]);