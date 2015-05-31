'use strict';

MetronicApp.controller('PaymentsController', ['$rootScope', '$scope', 'PaymentService', '$state', '$modal' , '$filter' , 'FileUploader', function ($rootScope, $scope, PaymentService, $state, $modal, $filter, FileUploader) {
    $scope.currentCustomerId = onlineUser.customerId;

    if (!$scope.initialized) {    //bind listeners only for the first time
        //server side events
        $scope.$on('PaymentService.search', function (event, data) {
            $scope.payments = data.result;
        });

        $scope.$on('PaymentService.getStats', function (event, data) {
            $scope.customerStats = data.result;
        });

        $scope.$on('PaymentService.addPayment', function (event, data) {
            $scope.paymentSubmitted = false;
            $rootScope.$emit('page.alert', {message:'پرداخت مورد نظر شما با موفقیت ثبت شد', type:"success"});
            $scope.doSearch();
            $scope.formAdd.$setPristine();
            initNewPayment();
        });

        $scope.$on('PaymentService.addPayment.error', function (event, data) {
            $scope.paymentSubmitted = false;
            if (data.exception.indexOf("minimum-payment-amount") > 0) {
                $rootScope.$emit('page.alert', {message:'حداقل میزان قابل پرداخت 2 امتیاز می باشد', type:"danger"});
            }
            if (data.exception.indexOf("payment-exceed-score") > 0) {
                $rootScope.$emit('page.alert', {message:'میزان درخواست شما بیش از امتیاز باقیمانده شما می باشد', type:"danger"});
            }

            if (data.exception.indexOf("customer-not-active") > 0) {
                $rootScope.$emit('page.alert', {message:'امکان ثبت پرداخت برای مشتری غیر فعال وجود ندارد.', type:"danger"});
            }
        });

        $scope.$on('PaymentService.deletePayment', function (event, data) {
            $rootScope.$emit('page.alert', {message:'پرداخت مورد نظر شما با موفقیت حذف شد', type:"success"});
            $scope.doSearch();
        });

        $scope.$on('PaymentService.rejectPayment', function (event, data) {
            $rootScope.$emit('page.alert', {message:'درخواست پرداخت به میزان ' + $filter('score')(data.result.amount) + ' امتیاز و با شناسه پرداخت ' + data.result.paymentId + ' به حالت عدم پذیرش تغییر یافت', type:"success"});
            $scope.doSearch();
        });


        $scope.$on('PaymentService.deletePayment.error', function (event, data) {
            $scope.paymentSubmitted = false;
            if (data.exception.indexOf("payment-not-pending") > 0) {
                $rootScope.$emit('page.alert', {message:'تنها پرداخت های بررسی نشده قابل حذف می باشد', type:"danger"});
                $scope.doSearch();
            }
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

    $scope.deletePayment = function (payment) {
        PaymentService.deletePayment(payment.id, {scope:$scope});
    }

    $scope.rejectPayment = function (payment) {
        PaymentService.rejectPayment(payment.id, {scope:$scope});
    }

    $scope.doSearch = function () {
        $scope.filter = $scope.filter || {};
        if ($scope.currentCustomerId) {
            $scope.filter.customerId = $scope.currentCustomerId;
        }

        PaymentService.search($scope.filter, {scope:$scope});
        PaymentService.getStats($scope.currentCustomerId, {scope:$scope});
    }

    $scope.doSearch();
    if ($scope.currentCustomerId) {
        PaymentService.getStats($scope.currentCustomerId, {scope:$scope});
    }


    if (!$scope.currentCustomerId) {
        PaymentService.getTotalStats();
    }


    function initNewPayment() {
        $scope.newPayment = {
        };
    }

    //handle customer entry
    $scope.submitPayment = function () {
        if ($scope.currentCustomerId) {
            $scope.newPayment.customerId = $scope.currentCustomerId;
        } else {
            $scope.newPayment.customerId = $scope.newPayment.customer.id;
        }

        $scope.newPayment.amount = $scope.newPayment.amountInput * 1000;
        PaymentService.addPayment($scope.newPayment, {scope:$scope});
        $scope.paymentSubmitted = true;
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




/*

    var dummy = new FileUploader.FileItem(uploader, {
        lastModifiedDate: new Date(),
        size: 1e6,
        type: 'image/jpeg',
        name: 'test_file_name'
    });

    dummy.progress = 100;
    dummy.isUploaded = true;
    dummy.isSuccess = true;
    uploader.queue.push(dummy);

*/

    var uploader = $scope.uploader = new FileUploader({
        autoUpload : true,
        isSingle:true
    });

    $scope.initialized = true;
}]);


