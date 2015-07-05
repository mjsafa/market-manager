'use strict';

angular.module('MetronicApp').controller('OnlineUserController', ['$rootScope', '$scope', 'UserService', '$state', '$modal', function ($rootScope, $scope, UserService, $state, $modal) {

    if (!$scope.initialized) {    //bind listeners only for the first time
        $rootScope.$on('UserService.setAgreed', function (event, data) {
            onlineUser.agreed = true;
            $scope.onlineUser = onlineUser;
            $state.go('customerDashboard');
        });
    }

    $rootScope.checkAnyRoles = function (rolesNames) {
        var hasPermission = false;
        angular.forEach(rolesNames, function (roleName) {
            if ($scope.onlineUser && $scope.onlineUser.roles && $scope.onlineUser.roles[roleName]) {
                hasPermission = true;
            }
        });
        return hasPermission;
    }

    $rootScope.isCustomer = function () {
        return ($rootScope.onlineUser.customerId ? true : false);
    }

    $rootScope.isOperator = function () {
        return ($rootScope.onlineUser.customerId ? false: true);
    }

    $rootScope.checkAnyGroups = function (userGroupNames) {
        var hasPermission = false;
        angular.forEach(userGroupNames, function (userGroupName) {
            if ($rootScope.onlineUser && $rootScope.onlineUser.userGroups && $rootScope.onlineUser.userGroups[userGroupName]) {
                hasPermission = true;
            }
        });
        return hasPermission;
    }

    $rootScope.onlineUser = onlineUser;

    $scope.setAgreed = function () {
        UserService.setAgreed($scope.onlineUser.id);
    }

    $scope.initialized = true;
}]);