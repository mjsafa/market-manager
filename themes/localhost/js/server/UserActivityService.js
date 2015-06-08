MetronicApp.factory("UserActivityService", function (JsonServer) {
    return {
        search:function (filter, entity, action, importance, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.useractivity', 'search', {filter:filter,
                entity:entity, action:action, importance:importance, start:0, maxResult:30, serviceContext:{scopeGroupId:scopeGroupId}}, {
                eventName:'UserActivityService.search',
                scope:options ? options.scope : undefined
            });
        }

    }
});