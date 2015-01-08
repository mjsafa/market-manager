'use strict';

MetronicApp.controller('OnlineUserController', ['$rootScope', '$scope', 'UserService', '$state', '$modal', function ($rootScope, $scope, UserService, $state, $modal) {

    if (!$scope.initialized) {    //bind listeners only for the first time
        $rootScope.$on('UserService.setAgreed', function (event, data) {
            onlineUser.agreed = true;
            $scope.onlineUser = onlineUser;
            $state.go('dashboard');
        });
    }

    $scope.checkAnyRoles = function (rolesNames) {
        var hasPermission = false;
        angular.forEach(rolesNames, function (roleName) {
            if ($scope.onlineUser && $scope.onlineUser.roles && $scope.onlineUser.roles[roleName]) {
                hasPermission = true;
            }
        });
        return hasPermission;
    }

    $scope.checkAnyGroups = function (userGroupNames) {
        var hasPermission = false;
        angular.forEach(userGroupNames, function (userGroupName) {
            if ($scope.onlineUser && $scope.onlineUser.userGroups && $scope.onlineUser.userGroups[userGroupName]) {
                hasPermission = true;
            }
        });
        return hasPermission;
    }

    $scope.onlineUser = onlineUser;

    $scope.setAgreed = function () {
        UserService.setAgreed($scope.onlineUser.id);
    }

    $scope.initialized = true;
}]);