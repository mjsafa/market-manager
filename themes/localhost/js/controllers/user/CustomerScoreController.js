'use strict';

MetronicApp.controller('CustomerScoreController', ['$rootScope', '$scope', 'CustomerService', '$state', '$modal', '$modalInstance','customer', function ($rootScope, $scope, CustomerService, $state, $modal, $modalInstance, customer) {

    $scope.newScore = {value: 0};
    $scope.customer = customer;


/*
    $rootScope.on('customer.score.openModal', function(event, data){
        $scope.customer = data;
    });
*/


    $scope.ok = function () {
        var newScore = {value: $scope.newScore.value, customerId: $scope.customer.id};
        $scope.newScore = {};
        $scope.customer = {};
        $modalInstance.close(newScore);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
     };
}]);