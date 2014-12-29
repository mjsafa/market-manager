'use strict';

MetronicApp.controller('CustomerDetailController',['$rootScope', '$scope', 'CustomerService','$stateParams',
    function($rootScope, $scope, CustomerService, $stateParams) {
        $scope.customerId = $stateParams.customerId;

        $scope.newCustomer = {};

        $scope.submitCustomer = function(){

        }
    }
]);