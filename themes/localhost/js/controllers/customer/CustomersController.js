'use strict';

angular.module('MetronicApp').controller('CustomersController', ['$rootScope', '$scope', 'CustomerService', 'ScoreService', '$state', '$modal', function ($rootScope, $scope, CustomerService, ScoreService, $state, $modal) {
    $scope.$on('$viewContentLoaded', function () {
        // initialize core components
        Metronic.initAjax();
    });

    if (!$scope.initialized) {
        $scope.currentCustomerId = onlineUser.customerId;
        $scope.customers = CustomerService.search('', $scope.currentCustomerId, {scope:$scope});

        $scope.$on('CustomerService.search', function (event, data) {
            $scope.customers = data.result;
        });

        $scope.$on('CustomerService.addCustomer', function (event, data) {
            $rootScope.$emit('page.alert', {message:'مشتری جدید در سیستم ثبت شد', type:"success"});
            $scope.doSearch();
            $scope.newCustomer = {};
            $scope.customer_form.$setPristine();
            $state.go('customers');

        });

        $scope.$on('CustomerService.addCustomer.error', function (event, data) {
            if (data.exception == "com.liferay.portal.DuplicateUserScreenNameException") {
                $rootScope.$emit('page.alert', {message:'آدرس ایمیل وارد شده تکراری می باشد', type:"danger"});
            } else if (data.exception == "com.liferay.portal.kernel.exception.PortalException: customer-maximum-invitee-exceed") {
                $rootScope.$emit('page.alert', {message:'هر مشتری حداکثر می تواند 12 نفر را در سیستم ثبت نماید', type:"danger"});
            }
        });

        $scope.$on('CustomerService.updateStatus', function (event, data) {
            if (data.result.isActive) {
                $rootScope.$emit('page.alert', {message:'مشتری با نام '+ data.result.name + ' فعال شد.', type:"success"});
            } else {
                $rootScope.$emit('page.alert', {message:'مشتری با نام '+ data.result.name + ' غیر فعال شد.', type:"success"});
            }
            angular.forEach($scope.customers, function (customer) {
                if (customer.id == data.result.customerId) {
                    customer.isActive = data.result.isActive;
                }
            });
        });


        $scope.$on('CustomerService.updateStatus.error', function (event, data) {
            //$scope.customer.isActive = $scope.customer.isActive ? false : true;
        });

        $scope.$on('ScoreService.addScore', function (event, data) {
            $rootScope.$emit('page.alert', {message:'امتیاز مورد نظر شما به درستی تخصیص یافت', type:"success"});
            $scope.doSearch();
        });

        $scope.$on('ScoreService.addScore.error', function (event, data) {
            if (data.exception.indexOf("customer-deactive") > -1) {
                $rootScope.$emit('page.alert', {message:'مشتری انتخاب شده غیر فعال می باشد. امتیاز تنها به مشتریان فعال تعلق می گیرد.', type:"danger"});
            }
        });
    }


    $scope.customerService = CustomerService;
    $scope.scoreService = ScoreService;

    $scope.doSearch = function () {
        $scope.customerService.search($scope.query, $scope.currentCustomerId, {scope:$scope});
    }


    //handle customer entry
    $scope.newCustomer = {
        score:0,
        mentorCustomer:{}
    };

    $scope.submitCustomer = function () {
        if ($scope.newCustomer.mentorCustomer && $scope.newCustomer.mentorCustomer.id) {
            $scope.newCustomer.mentorCustomerId = $scope.newCustomer.mentorCustomer.id;
        } else if ($scope.currentCustomerId) {
            $scope.newCustomer.mentorCustomerId = $scope.currentCustomerId;
        }
        $scope.customerService.addCustomer($scope.newCustomer, {scope:$scope});
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


    $scope.openScore = function (size, customer) {
        $scope.selectedCustomer = customer;
        var scoreModal = $modal.open({
            templateUrl:'scoreModal.html',
            controller:'CustomerScoreController',
            size:size,
            resolve:{
                customer:function () {
                    return $scope.selectedCustomer;
                }
            }
        });

        $scope.scoreModal = scoreModal;

        scoreModal.result.then(function (score) {
            $scope.scoreService.addScore(score.customerId, score.value * 1000.0, {scope:$scope});
        }, function () {
            //$log.info('Modal dismissed at: ' + newDate());
        });
    };

    function calculateScore() {
        var totalScore = 0;
        angular.forEach($scope.customers, function (customer) {
            totalScore += customer.score;
        });

        return totalScore;
    }

    $scope.changeStatus = function (customer) {
        if (customer.isActive) {
            $scope.customerService.updateStatus(customer.id, false, {scope:$scope});
        } else {
            $scope.customerService.updateStatus(customer.id, true, {scope:$scope});
        }
    };

    $scope.openExpireDate = function ($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.expireIsOpen = true;
    };

    $scope.dateOptions = {
        minDate:new Date(),
        yearRange:6
    };

    $scope.totalScore = calculateScore();
    $scope.initialized = true;
}]);
