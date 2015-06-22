'use strict';

angular.module('MetronicApp').controller('PaymentDownloadController', ['$rootScope', '$scope', 'PaymentService', '$state', '$modal', function ($rootScope, $scope, PaymentService, $state, $modal) {

    if (!$scope.initialized) {    //bind listeners only for the first time
        //server side events
        $scope.$on('PaymentService.search', function (event, data) {
            $scope.payments = data.result.result;
            $scope.totalPayments = data.result.total;
        });

        $scope.$on('PaymentService.isDownloaded', function (event, data) {
            $scope.isDownloaded = data.result.isDownloaded ? 1 : 2;
            $scope.doSearch();
        });
        $scope.$on('PaymentService.downloadPayments', function (event, data) {
            $scope.checkIsDownload();
            $scope.doSearch();
            window.location = "/delegate/payment?groupId=" + scopeGroupId;
        });
        $scope.$on('PaymentService.acceptPayments', function (event, data) {
            $rootScope.$emit('page.alert', {message:'تایید پرداخت ها با موفقیت انجام شد', type:"success"});
            $scope.checkIsDownload();
            $scope.doSearch();
        });
        $scope.$on('PaymentService.cancelDownloadPayments', function (event, data) {
            $rootScope.$emit('page.alert', {message:'لغو پرداخت ها با موفقیت انجام شد', type:"success"});
            $scope.checkIsDownload();
            $scope.doSearch();
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

        $scope.filter.currentPage = 1;
        $scope.itemsPerPage = 10;

        initNewPayment();
    }


    $scope.$on('$viewContentLoaded', function () {
        Metronic.initAjax();
    });

    $scope.isDownloaded = 0;
    $scope.checkIsDownload = function () {
        PaymentService.isDownloaded({scope:$scope});
    }

    $scope.downloadPayments = function () {
        PaymentService.downloadPayments({scope:$scope});
    }
    $scope.cancelDownloadPayments = function () {
        PaymentService.cancelDownloadPayments({scope:$scope});
    }
    $scope.acceptPayments = function () {
        PaymentService.acceptPayments({scope:$scope});
    }


    $scope.doSearch = function () {
        if ($scope.isDownloaded == 0) {
            $scope.filter.status = 1;
        } else if ($scope.isDownloaded == 1) {
            $scope.filter.status = 20;
        } else if ($scope.isDownloaded == 2) {
            $scope.filter.status = 1;
        }

        $scope.filter.first = ($scope.filter.currentPage -1) * $scope.itemsPerPage;
        $scope.filter.maxResults = $scope.itemsPerPage;

        PaymentService.search($scope.filter, {scope:$scope});
    }

    $scope.doSearch();
    $scope.checkIsDownload();
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

    $scope.removeCustomerFilter = function () {
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