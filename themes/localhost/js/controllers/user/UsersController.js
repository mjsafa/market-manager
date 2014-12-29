'use strict';

MetronicApp.controller('UsersController', ['$rootScope', '$scope','CustomerService', 'UserService', '$state', '$modal', function ($rootScope, $scope, CustomerService, UserService, $state, $modal) {
    $scope.$on('$viewContentLoaded', function () {
        // initialize core components
        Metronic.initAjax();
    });

    $scope.customers = CustomerService.search('');
    $scope.customerService = CustomerService;
    $scope.userService = UserService;

    $scope.doSearch = function () {
        $scope.customerService.search($scope.query);
    }


    //handle customer entry
    $scope.newUser = {
    };

    $scope.submitUser = function () {
        $scope.userService.addUser($scope.newUser);
        $state.go('users');
        $scope.newUser = {};
        CustomersTools.init();
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




}]);