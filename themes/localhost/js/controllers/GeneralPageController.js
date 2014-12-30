/* Setup general page controller */
MetronicApp.controller('GeneralPageController', ['$rootScope', '$scope', 'settings', '$rootScope', function ($rootScope, $scope, settings, $rootScope) {
    $scope.$on('$viewContentLoaded', function () {
        // initialize core components
        Metronic.initAjax();

        // set default layout mode
        $rootScope.settings.layout.pageBodySolid = false;
        $rootScope.settings.layout.pageSidebarClosed = false;
    });

    $scope.alerts = [];
    $rootScope.$on('page.alert', function (event, data) {
        $scope.alerts.push(data);
    });

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };
}]);
