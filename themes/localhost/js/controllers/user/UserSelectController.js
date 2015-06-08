'use strict';

MetronicApp.controller('UserSelectController', ['$rootScope', '$scope', 'UserService', '$state', '$modal', '$modalInstance', function ($rootScope, $scope, UserService, $state, $modal, $modalInstance, users) {

    if (!$scope.initialized) {
        $scope.$on('UserService.findActiveUsers', function (event, data) {
            $scope.users = data.result;
        });

        UserService.findActiveUsers('', {scope: $scope});
    }


    $scope.doSearch = function () {
        UserService.findActiveUsers($scope.query || '', {scope: $scope});
    }

    $scope.ok = function (item) {
        $modalInstance.close(item);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };

    $scope.initialized = true;
}]);