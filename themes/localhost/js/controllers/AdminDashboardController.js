'use strict';

angular.module('MetronicApp').controller('AdminDashboardController', ['$rootScope', '$scope', 'CustomerService', 'ScoreService', 'UserService', '$state', '$modal', function ($rootScope, $scope, CustomerService, ScoreService, UserService, $state, $modal) {
    if (!$scope.initialized) {
        $scope.timePeriod = 'month';
        $scope.stats = $scope.stats || {};
        ScoreService.findByCustomerId(null, 0, 30, {});

        ScoreService.totalChartData($scope.timePeriod);
        ScoreService.totalStats();
        CustomerService.getTotalStats();


        $rootScope.$on('ScoreService.totalChartData', function (event, data) {
            $scope.scoreChartData = {
                "series":[""],
                "data":[]
            }
            angular.forEach(data.result.records, function (record) {
                $scope.scoreChartData.data.push({"x":record.date, "y":[record.value]});
            });
        });

        //load STATS
        $rootScope.$on('ScoreService.totalStats', function (event, data) {
            $scope.stats.totalScores = data.result.totalScores;
            $scope.stats.totalWeekScores = data.result.totalWeekScores;
        });
        $rootScope.$on('CustomerService.getTotalStats', function (event, data) {
            $scope.stats.totalCustomers = data.result.totalCustomers;
            $scope.stats.totalWeekCustomers = data.result.lastWeekCustomers;
        });

        $rootScope.$on('ScoreService.findByCustomerId', function (event, data) {
            $scope.scores = data.result;
        });
    }


    $scope.scoreChartConfig = {
        title:'',
        tooltips:true,
        labels:false,
        mouseover:function () {
        },
        mouseout:function () {
        },
        click:function () {
        },
        legend:{
            display:true,
            //could be 'left, right'
            position:'right'
        },
        innerRadius:0, // applicable on pieCharts, can be a percentage like '50%'
        lineLegend:'tradditional' // can be also 'traditional'
    }

    $scope.initialized = true;
}]);