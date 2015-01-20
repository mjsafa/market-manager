MetronicApp.factory("ScoreService", function (JsonServer) {
    return{
        addScore:function (customerId, value, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.score', 'add-score', {customerId:customerId, value:value, serviceContext:{}}, {
                eventName:'ScoreService.addScore',
                scope:options ? options.scope : undefined
            });
        },
        findByCustomerId:function (customerId, start, total, filter) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.score', 'customer-scores', {customerId:customerId, start:start, total:total, filter:JSON.stringify(filter), serviceContext:{}}, {
                eventName:'ScoreService.findByCustomerId'
            });
        },
        customerChartData:function (customerId) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.score', 'customer-scores-by-date', {customerId:customerId, fromDate:'', toDate:'', serviceContext:{}}, {
                eventName:'ScoreService.customerChartData'
            });
        },
        totalChartData:function (timePeriod) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.score', 'scores-by-date', {timePeriod:timePeriod, fromDate:'', toDate:'', serviceContext:{}}, {
                eventName:'ScoreService.totalChartData'
            });
        },
        totalStats:function () {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.score', 'get-total-stats', {serviceContext:{}}, {
                eventName:'ScoreService.totalStats'
            });
        }

    };
});