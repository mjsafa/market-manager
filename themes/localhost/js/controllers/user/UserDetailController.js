'use strict';

MetronicApp.controller('UserDetailController', ['$rootScope', '$scope', 'UserService', 'ScoreService', '$stateParams', '$state', '$modal',
    function ($rootScope, $scope, UserService, ScoreService, $stateParams, $state, $modal) {
        if (!$scope.initialized) {    //bind listeners only for the first time
            //server side events
            $rootScope.$on('UserService.getById', function (event, data) {
                $scope.user = data.result;
            });
        }

        $scope.userId = $stateParams.userId;
        $scope.userService = UserService;
        $scope.userService.getById($scope.userId);

        $scope.initialized = true;
        $scope.goUserList = function(){
              $state.go('users');
        }
    }
]);