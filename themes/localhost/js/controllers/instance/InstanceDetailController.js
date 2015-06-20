MetronicApp.controller('InstanceDetailController', ['$rootScope', '$scope', 'InstanceService', '$stateParams', '$state', '$modal','$filter', 'FileUploader', function ($rootScope, $scope, InstanceService, $stateParams, $state, $modal, $filter, FileUploader) {

    $scope.instanceId = $stateParams.instanceId;
    InstanceService.getInstanceById($scope.instanceId, {scope: $scope})

    if (!$scope.initialized) {
        $scope.$on('InstanceService.getInstanceById', function (event, data) {
            $scope.instance = data.result;
        });

        $scope.$on('InstanceService.updateInstance', function (event, data) {
            $scope.uploader.clearQueue();

            $rootScope.$emit('page.alert', {message:'بروز رسانی نمایندگی به درستی انجام شد', type:"success"});
        });
    }

    $scope.openUserPopup = function (size) {
        var modalInstance = $modal.open({
            templateUrl:'userModalContent.html',
            controller:'UserSelectController',
            size:size,
            resolve:{
                products:function () {
                }
            }
        });

        $scope.modalInstance = modalInstance;

        modalInstance.result.then(function (selectedItem) {
            $scope.instance.superAdmin = selectedItem;
        }, function () {
            //$log.info('Modal dismissed at: ' + new Date());
        });
    }

    $scope.submitInstance = function () {
        if(1 ==  $scope.uploader.queue.length) {
            $scope.instance.logo = $scope.uploader.queue[0].url;
        }

        if ($scope.instance.superAdmin) {
            $scope.instance.superAdminId = $scope.instance.superAdmin.id;
        }

        InstanceService.updateInstance($scope.instance, {scope: $scope});
    };

    $scope.goInstanceList = function () {
        $state.go('instances');
    };

    $scope.uploader = new FileUploader({
        autoUpload : true,
        isSingle:true
    });

}]);