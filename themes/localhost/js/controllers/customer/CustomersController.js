'use strict';

MetronicApp.controller('CustomersController', ['$rootScope', '$scope', 'CustomerService', 'ScoreService', '$state', '$modal', function ($rootScope, $scope, CustomerService, ScoreService, $state, $modal) {
    $scope.$on('$viewContentLoaded', function () {
        // initialize core components
        Metronic.initAjax();
    });

    $scope.customers = CustomerService.search('');
    $scope.customerService = CustomerService;
    $scope.scoreService = ScoreService;

    $scope.doSearch = function () {
        $scope.customerService.search($scope.query);
    }


    //handle customer entry
    $scope.newCustomer = {
        score:0,
        mentorCustomer:{}
    };
    $scope.submitCustomer = function () {
        if ($scope.newCustomer.mentorCustomer) {
            $scope.newCustomer.mentorCustomerId = $scope.newCustomer.mentorCustomer.id;
        }

        $scope.customerService.lastId++;
        $scope.newCustomer.id = $scope.customerService.lastId;
        $scope.customers.unshift($scope.newCustomer);
        $scope.newCustomer = {};
        $state.go('customers');
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
            var _customer = $scope.customerService.getById(score.customerId);
            $scope.scoreService.addScore(_customer, score.value)
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

    $scope.totalScore = calculateScore();

}]);