'use strict';

MetronicApp.controller('OnlineUserController', ['$rootScope', '$scope', 'UserService', '$state', '$modal', function ($rootScope, $scope, UserService, $state, $modal) {

    if (!$scope.initialized) {    //bind listeners only for the first time
        $rootScope.$on('UserService.setAgreed', function (event, data) {
            onlineUser.agreed = true;
            $scope.onlineUser = onlineUser;
            $state.go('dashboard');
        });
    }

    $scope.onlineUser = onlineUser;

    $scope.setAgreed = function () {
        UserService.setAgreed($scope.onlineUser.id);
    }

    $scope.initialized = true;
}]);