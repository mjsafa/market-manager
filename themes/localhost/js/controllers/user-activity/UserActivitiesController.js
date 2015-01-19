MetronicApp.controller('UserActivitiesController', ['$rootScope', '$scope', 'UserActivityService', '$state', '$modal', function ($rootScope, $scope, UserActivityService, $state, $modal) {
    $rootScope.settings.layout.pageBodySolid = true;
    $rootScope.settings.layout.pageSidebarClosed = false;

    UserActivityService.search('', '', '', '');

    if (!$scope.initialized) {
        $rootScope.$on('UserActivityService.search', function (event, data) {
            $scope.activities = data.result;

            angular.forEach($scope.activities, function (activity) {
                activity.data = activity.data[0];
            });
        });
    };

    $scope.doSearch = function () {
        UserActivityService.search($scope.query || '', $scope.selectedEntity || '',
            $scope.selectedAction || '', $scope.selectedImportance || '');
    };

    $scope.importances = [
        {value: 1, text: 'بالا',className:'label-danger'},
        {value: 2, text: 'متوسط' ,className:'label-warning'},
        {value: 3, text: 'پایین',className:'label-success'}
    ];

    $scope.entities = [
        {value: 'Invoice', text: 'فاکتور'},
        {value: 'InvoiceItem', text: 'اقلام فاکتور'}
    ];

    $scope.actions = [
        {value: 1, text: 'افزودن'},
        {value: 2, text: 'ویرایش'},
        {value: 3, text: 'حذف'}
    ];

    $scope.getName = function(input, data, param) {
        var result = 'none';

        angular.forEach(data, function (object) {
            if(object.value == input){
                result = object[param];
            }
        });

        return result;
    };

    $scope.showImportance = function(input) {
        return $scope.getName(input, $scope.importances, 'text');
    };

    $scope.showImportanceClass = function(input) {
        return $scope.getName(input, $scope.importances, 'className');
    };

    $scope.showEntity = function(input) {
        return $scope.getName(input, $scope.entities, 'text');
    };

    $scope.showAction = function(input) {
        return $scope.getName(input, $scope.actions, 'text');
    };

    $scope.getLinkURL = function(entity, data) {
        if(entity == "Invoice") {
            return "invoice/" + data.id;
        }

        if(entity == "InvoiceItem") {
            return "invoice/" + data.invoiceId;
        }

    }

    $scope.getExplain = function(entity, data) {
        if(entity == "InvoiceItem") {
            return "نام جنس: " + data.productName
                    + " - کد جنس: " + data.productCode
                    +" - قیمت پایه: " + data.basePrice
                    + " - تعداد: "  + data.number;
        }

        if(entity == "Invoice") {
            return "اطلاعات تا لحظه ثبت: "
                   + "تعداد اقلام : " + data.itemNumber
                   + " - جمع کل هزینه: " + data.totalCost
                   + " - مشتری : " + data.customerName;;
        }
    }

    $scope.initialized = true;
}]);