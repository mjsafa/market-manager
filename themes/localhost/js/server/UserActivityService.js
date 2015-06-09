MetronicApp.factory("UserActivityService", function (JsonServer) {
    return {
        search:function (filter, text, entity, action, importance, options) {
            var _filter = angular.copy(filter, _filter);
            if(_filter){
                if(_filter.fromDate){
                    _filter.fromDate = _filter.fromDate.getTime();
                } else {
                    _filter.fromDate = null;
                }

                if(_filter.toDate){
                    _filter.toDate = _filter.toDate.getTime();
                } else {
                    _filter.toDate = null;
                }
            }

            var result = JsonServer.postByUrl('/csb-modules-service-portlet.useractivity', 'search', {
                text:text, entity:entity, action:action, importance:importance,
                fromDate:_filter.fromDate, toDate:_filter.toDate, start:_filter.first, maxResult:_filter.maxResults,
                serviceContext:{scopeGroupId:scopeGroupId}}, {
                eventName:'UserActivityService.search',
                scope:options ? options.scope : undefined
            });
        }

    }
});