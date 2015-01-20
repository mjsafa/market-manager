/* Setup general page controller */
MetronicApp.controller('GeneralPageController', ['$rootScope', '$scope', 'settings', '$rootScope', '$state', '$window', '$location', '$timeout', function ($rootScope, $scope, settings, $rootScope, $state, $window, $location , $timeout) {
    $scope.$on('$viewContentLoaded', function () {
        // initialize core components
        Metronic.initAjax();

        // set default layout mode
        $rootScope.settings.layout.pageBodySolid = false;
        $rootScope.settings.layout.pageSidebarClosed = false;
    });

    $scope.alerts = [];
    $rootScope.$on('page.alert', function (event, data) {
        data.index = $scope.alerts.length + 1;
        $scope.alerts.unshift(data);
        Metronic.scrollTo($('#alert_container'));

        $timeout(function () {
            $scope.alerts.splice( $scope.alerts.length - 1 , 1 );;
        }, 6000);
    });

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };

    if (!onlineUser.agreed && onlineUser.userGroups && onlineUser.userGroups.customer_group) {
        $state.go("userAgreement");
    } else if (onlineUser.roles && onlineUser.roles.Guest) {
        $window.location.href = '/login';
    }

    $rootScope.$on('$stateChangeSuccess', function () {
        if (!onlineUser.agreed && onlineUser.userGroups && onlineUser.userGroups.customer_group) {
//            event.preventDefault();
            $state.go('userAgreement');
            $location.path("/userAgreement");

        } else if (onlineUser.roles && onlineUser.roles.Guest) {
            $window.location.href = '/login';
        }
    });

}]);
