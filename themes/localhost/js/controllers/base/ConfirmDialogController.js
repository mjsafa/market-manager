'use strict';

angular.module('MetronicApp').controller('ConfirmDialogController', ['$rootScope', '$scope', '$state', '$modal', '$modalInstance', function ($rootScope, $scope, $state, $modal, $modalInstance, customers) {

    $scope.ok = function () {
        $modalInstance.close();
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };

}]);