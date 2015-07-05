angular.module('MetronicApp').controller('InstancesController', ['$rootScope', '$scope', 'InstanceService', '$state', '$modal','$filter', 'FileUploader', function ($rootScope, $scope, InstanceService, $state, $modal, $filter, FileUploader) {
    $rootScope.settings.layout.pageBodySolid = true;
    $rootScope.settings.layout.pageSidebarClosed = false;

    InstanceService.search('', -1, {scope: $scope});

    $scope.$on('$viewContentLoaded', function () {
        Metronic.initAjax();
    });

    $scope.initialData = function () {
        $scope.newInstance = {
            superAdmin: {}
        };
    }

    $scope.initialData();

    if (!$scope.initialized) {
        $scope.$on('InstanceService.addInstance', function (event, data) {
            $scope.doSearch();
            $scope.initialData();

            $scope.uploader.clearQueue();

            $rootScope.$emit('page.alert', {message:'نمایندگی جدید در سامانه ثبت شد.', type:"success"});
        });

        $scope.$on('InstanceService.updateInstance', function (event, data) {
            $scope.doSearch();
            $rootScope.$emit('page.alert', {message:'ویرایش نمایندگی با موفقیت انجام شد.', type:"success"});
        });


        $scope.$on('InstanceService.search', function (event, data) {
            $scope.instances = data.result;
        });

        $scope.$on('InstanceService.updateInstanceStatus', function (event, data) {
            $scope.doSearch();
            $rootScope.$emit('page.alert', {message:'بروز رسانی وضعیت نمایندگی به درستی انجام شد.', type:"success"});
        });
    }

    $scope.statuses = [
        {value:21, text:'فعال'},
        {value:5, text:'غیر فعال'}
    ];

    $scope.doSearch = function () {
        InstanceService.search($scope.query || '', $scope.selectedStatus || -1, {scope: $scope});
    }

    $scope.submitInstance = function () {
        if(1 ==  $scope.uploader.queue.length) {
            $scope.newInstance.logo = $scope.uploader.queue[0].url;
        }

        if($scope.newInstance.superAdmin) {
            $scope.newInstance.superAdminId = $scope.newInstance.superAdmin.id;
        }

        InstanceService.addInstance($scope.newInstance, {scope: $scope});
    }

    $scope.getName = function (input, data, param) {
        var result = 'none';

        angular.forEach(data, function (object) {
            if (object.value == input) {
                result = object[param];
            }
        });

        return result;
    };

    $scope.showStatus = function (input) {
        return $scope.getName(input, $scope.statuses, 'text');
    };

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
            $scope.newInstance.superAdmin = selectedItem;
        }, function () {
            //$log.info('Modal dismissed at: ' + new Date());
        });
    }

    $scope.updateStatus = function(instanceId ,newStatus) {
        InstanceService.updateInstanceStatus(instanceId, newStatus, {scope: $scope});
    }

    $scope.uploader = new FileUploader({
        autoUpload : true,
        isSingle:true
    });

    $scope.initialized = true;

}]);