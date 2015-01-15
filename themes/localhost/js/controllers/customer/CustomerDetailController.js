'use strict';

MetronicApp.controller('CustomerDetailController', ['$rootScope', '$scope', 'CustomerService', 'ScoreService', '$stateParams', '$state', '$modal', 'UserService',
    function ($rootScope, $scope, CustomerService, ScoreService, $stateParams, $state, $modal, UserService) {

        if (!$scope.initialized) {    //bind listeners only for the first time
            //server side events
            $rootScope.$on('CustomerService.getById', function (event, data) {
                $scope.customer = data.result;
                //load invitee customers
                CustomerService.getInvitees($scope.customer.id);
                CustomerService.getStats($scope.customer.id);
                ScoreService.customerChartData($scope.customer.id);
                ScoreService.findByCustomerId($scope.customer.id, 0 ,30 , {});
            });

            $rootScope.$on('CustomerService.getInvitees', function (event, data) {
                $scope.customer.invitees = data.result;
                $scope.inviteesTotalScore = $scope.inviteesScore();
            });

            $rootScope.$on('ScoreService.customerChartData', function (event, data) {
                $scope.scoreChartData = {
                    "series":[
                        ""
                    ],
                    "data":[
                    ]
                }
                angular.forEach(data.result.records, function (record) {
                    $scope.scoreChartData.data.push({"x":record.date, "y":[record.value]});
                });
            });

            $rootScope.$on('CustomerService.getStats', function (event, data) {
                $scope.stats = data.result;
            });

            $rootScope.$on('ScoreService.findByCustomerId', function (event, data) {
                $scope.scores = data.result;
            });
        }

        $scope.scoreService = ScoreService;

        $scope.customerId = $stateParams.customerId;
        if (!$scope.customerId && UserService.getOnlineUser() && UserService.getOnlineUser().customerId) {
            $scope.customerId = UserService.getOnlineUser().customerId;
        }
        CustomerService.getById($scope.customerId);

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

        $scope.updateCustomer = function(){
            CustomerService.updateCustomer($scope.customer);
        }

        $scope.scoreChartConfig = {
            title:'',
            tooltips:true,
            labels:false,
            mouseover:function () {
            },
            mouseout:function () {
            },
            click:function () {
            },
            legend:{
                display:true,
                //could be 'left, right'
                position:'right'
            },
            innerRadius:0, // applicable on pieCharts, can be a percentage like '50%'
            lineLegend:'tradditional' // can be also 'traditional'
        }


        $scope.initialized = true;
    }
]);