'use strict';

MetronicApp.controller('UserDetailController', ['$rootScope', '$scope', 'UserService', '$stateParams', '$state', '$modal',
    function ($rootScope, $scope, UserService, $stateParams, $state, $modal) {
        $scope.user = {roles:[]};
        $scope.userService = UserService;
        $scope.userId = $stateParams.userId;
        if (!$scope.userId) {
            $scope.userId = onlineUser.id;
        }

        if (!$scope.initialized) {    //bind listeners only for the first time
            $scope.userService.getById($scope.userId, {scope:$scope});

            //server side events
            $scope.$on('UserService.getById', function (event, data) {
                $scope.user = data.result;
            });

            $scope.$on('UserService.updatePassword', function (event, data) {
                $rootScope.$emit('page.alert', {message:'رمز عبور شما با موفقیت تغییر یافت', type:"success"});
                $scope.changePassword = {};
                $scope.changePasswordForm.$setPristine();
            });

            $scope.$on('UserService.updateUser', function (event, data) {
                $rootScope.$emit('page.alert', {message:'اطلاعات و دسترسی های کاربر با موفقیت ویرایش شد', type:"success"});
                $scope.userService.getById($scope.userId, {scope:$scope});
            });

            $scope.$on('UserService.updatePassword.error', function (event, data) {
                if (data.exception.indexOf("wrong-current-password")) {
                    $rootScope.$emit('page.alert', {message:'رمز عبور فعلی شما صحیح نمی باشد', type:"danger"});
                }

            });

            $scope.changePassword = {};
        }

        $scope.submitChangePassword = function () {
            UserService.updatePassword($scope.userId, $scope.changePassword.oldPassword, $scope.changePassword.password1, $scope.changePassword.password2, {scope:$scope});
        }


        $scope.initialized = true;
        $scope.goUserList = function () {
            $state.go('users');
        }

        $scope.updateUser = function () {
            UserService.updateUser($scope.user, {scope:$scope});
        }

        $scope.roleConstants = [
            {value:'ADMINISTRATOR_USER', text:'کاربر سطح بالا'},
            {value:'CUSTOMER_MANAGER', text:'مدیریت مشتریان'},
            {value:'USER_MANAGER', text:'مدیریت اپراتور ها و مدیران'},
            {value:'INVOICE_MANAGER', text:'مدیریت فاکتور ها'},
            {value:'PAYMENT_MANAGER', text:'مدیریت پرداخت ها'}
        ];

        $scope.userRoles = function () {
            var selected = [];
            angular.forEach($scope.roleConstants, function (s) {
                if ($scope.user.roles.indexOf(s.value) >= 0) {
                    selected.push(s);
                }
            });

            return selected;
        }
    }
]);

