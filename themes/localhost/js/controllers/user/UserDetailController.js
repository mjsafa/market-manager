'use strict';

MetronicApp.controller('UserDetailController', ['$rootScope', '$scope', 'UserService', 'ScoreService', '$stateParams', '$state', '$modal',
    function ($rootScope, $scope, UserService, ScoreService, $stateParams, $state, $modal) {
        $scope.userService = UserService;
        $scope.userId = $stateParams.userId;

        if (!$scope.initialized) {    //bind listeners only for the first time
            $scope.userService.getById($scope.userId);

            //server side events
            $rootScope.$on('UserService.getById', function (event, data) {
                $scope.user = data.result;
            });
        }


        $scope.initialized = true;
        $scope.goUserList = function(){
              $state.go('users');
        }
    }
]);