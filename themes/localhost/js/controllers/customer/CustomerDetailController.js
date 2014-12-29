'use strict';

MetronicApp.controller('CustomerDetailController', ['$rootScope', '$scope', 'CustomerService', 'ScoreService', '$stateParams', '$state', '$modal',
    function ($rootScope, $scope, CustomerService, ScoreService, $stateParams, $state, $modal) {

        $scope.scoreService = ScoreService;

        $scope.customerId = $stateParams.customerId;
        $scope.customer = CustomerService.getById($scope.customerId);

        //load mentor customer
        if ($scope.customer.mentorCustomerId) {
            $scope.customer.mentorCustomer = CustomerService.getById($scope.customer.mentorCustomerId);
        }

        //load invitee customers
        $scope.customer.invitees = CustomerService.findInvitees($scope.customer.id);

        $scope.goCustomerList = function () {
            $state.go('customers');
        }

        $scope.inviteesScore = function () {
            var totalScore = 0;
            angular.forEach($scope.customer.invitees, function (invitee) {
                totalScore += invitee.score;
            });

            return totalScore;
        }

        $scope.inviteesTotalScore = $scope.inviteesScore();


        //Select Invitee Modal
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
                //$scope.customer.invitees.push(selectedItem);
                CustomerService.addInvitee($scope.customer, selectedItem);
            }, function () {
                //$log.info('Modal dismissed at: ' + new Date());
            });
        };

        $scope.deleteInvitee = function (invitee) {
            CustomerService.deleteInvitee($scope.customer, invitee);
        };

        $scope.chartObject = {};

        $scope.chartObject.data = $scope.scoreService.chartData($scope.customer.id);

        $scope.chartObject.type = 'LineChart';
        $scope.chartObject.options = {
            'title':'امتیاز کسب شده توسط مشتری'
        }
    }
]);