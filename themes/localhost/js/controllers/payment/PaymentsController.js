'use strict';

MetronicApp.controller('PaymentsController', ['$rootScope', '$scope', 'PaymentService', '$state', '$modal', function ($rootScope, $scope, PaymentService, $state, $modal) {

    if (!$scope.initialized) {    //bind listeners only for the first time
        //server side events
        $scope.$on('PaymentService.search', function (event, data) {
            $scope.payments = data.result;
        });

        $scope.$on('PaymentService.addPayment', function (event, data) {
            $rootScope.$emit('page.alert', {message:'پرداخت مورد نظر شما با موفقیت ثبت شد', type:"success"});
            $scope.doSearch();
            $scope.formAdd.$setPristine();
            initNewPayment();
        });

        $rootScope.$on('PaymentService.getTotalStats', function (event, data) {
            $scope.stats = data.result;
        });

        $scope.filter = $scope.filter || {};
        initNewPayment();
    }


    $scope.$on('$viewContentLoaded', function () {
        // initialize core components
        Metronic.initAjax();
    });


    $scope.doSearch = function () {
        PaymentService.search($scope.filter, {scope:$scope});
    }

    $scope.doSearch();
    PaymentService.getTotalStats();


    function initNewPayment() {
        $scope.newPayment = {
        };
    }

    //handle customer entry
    $scope.submitPayment = function () {
        $scope.newPayment.customerId = $scope.newPayment.customer.id;
        PaymentService.addPayment($scope.newPayment, {scope:$scope});
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
            $scope.newPayment.customer = selectedItem;
        }, function () {
            //$log.info('Modal dismissed at: ' + new Date());
        });
    };

    $scope.removeCustomerFilter = function(){
        $scope.filterCustomer = undefined;
        $scope.filter.customerId = undefined;
        $scope.doSearch();
    }

    $scope.openCustomerFilter = function (size) {
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

        modalInstance.result.then(
            function (selectedItem) {
                $scope.filterCustomer = selectedItem;
                $scope.filter.customerId = selectedItem.id;
                $scope.doSearch();
            }, function () {
            }
        );
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