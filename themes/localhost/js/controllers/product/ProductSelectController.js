'use strict';

MetronicApp.controller('ProductSelectController', ['$rootScope', '$scope', 'ProductService', '$state', '$modal', '$modalInstance', function ($rootScope, $scope, ProductService, $state, $modal, $modalInstance, products) {

    if (!$scope.initialized) {
        $scope.$on('ProductService.search', function (event, data) {
            $scope.products = data.result;
        });

        ProductService.search('', 21, {scope: $scope});
    }


    $scope.doSearch = function () {
        ProductService.search($scope.query || '', 21, {scope: $scope});
    }

    $scope.ok = function (item) {
        $modalInstance.close(item);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };

    $scope.initialized = true;
}]);