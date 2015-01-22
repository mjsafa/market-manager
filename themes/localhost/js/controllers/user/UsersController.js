'use strict';

MetronicApp.controller('UsersController', ['$rootScope', '$scope', 'UserService', '$state', '$modal', function ($rootScope, $scope, UserService, $state, $modal) {

    if (!$scope.initialized) {    //bind listeners only for the first time
        //server side events
        $rootScope.$on('UserService.find', function (event, data) {
            $scope.users = data.result;
        });

        $rootScope.$on('UserService.addUser', function (event, data) {
            $rootScope.$emit('page.alert', {message:'کاربر مورد نظر شما با موفقیت ثبت شد', type:"success"});
            $scope.doSearch();
            $scope.newUser = {roles:{}};
            $scope.userForm.$setPristine();
        });

        $rootScope.$on('UserService.updateStatus', function (event, data) {
            $rootScope.$emit('page.alert', {message:'وضعیت کاربر مورد نظر به درستی تغییر یافت', type:"success"});
        });
    }


    $scope.$on('$viewContentLoaded', function () {
        // initialize core components
        Metronic.initAjax();
    });


    $scope.userService = UserService;
    $scope.userService.find('');


    $scope.doSearch = function () {
        $scope.userService.find($scope.query);
    }


    //handle customer entry
    $scope.newUser = {
        roles:{}
    };

    $scope.submitUser = function () {
        $scope.userService.addUser($scope.newUser);
    }


    // set sidebar closed and body solid layout mode
    $rootScope.settings.layout.pageBodySolid = true;
    $rootScope.settings.layout.pageSidebarClosed = false;


    $scope.open = function (size) {
        var modalInstance = $modal.open({
            templateUrl:'myModalContent.html',
            controller:'CustomerSelectController',
            size:size,
            resolve:{
                customers:function () {
                    return $scope.customers;
                }
            }
        });

        $scope.modalInstance = modalInstance;

        modalInstance.result.then(function (selectedItem) {
            $scope.newCustomer.mentorCustomer = selectedItem;
        }, function () {
            //$log.info('Modal dismissed at: ' + new Date());
        });
    };

    $scope.changeStatus = function (user) {
        if (user.isActive) {
            $scope.userService.updateStatus(user.id, false);
        } else {
            $scope.userService.updateStatus(user.id, true);
        }
    };

    $scope.initialized = true;
}]);