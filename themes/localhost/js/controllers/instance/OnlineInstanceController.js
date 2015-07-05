angular.module('MetronicApp').controller('OnlineInstanceController', ['$rootScope', '$scope', 'InstanceService', '$state', '$modal', function ($rootScope, $scope, InstanceService, $state, $modal) {

    if (!$scope.initialized) {
        $rootScope.$on('InstanceService.getInstanceByGroupId', function (event, data) {
            $scope.onlineInstance = data.result;
        });
    }

    $scope.initial = function () {
        $scope.onlineInstance = {};
        if(0==scopeGroupId) {
            $scope.onlineInstance.logo = "/delegate/resource/assets/admin/layout/img/logo.png";
        } else {
            InstanceService.getInstanceByGroupId(scopeGroupId, {scope: $scope});
        }
    }

    $scope.initial();

    $scope.initialized = true;
}]);