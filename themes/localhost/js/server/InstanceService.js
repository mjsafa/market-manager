MetronicApp.factory("InstanceService", function (JsonServer) {
    return {
        search:function (filter, status, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.instance', 'search', {filter:filter, status:status, start:0, maxResult:30, serviceContext:{}}, {
                eventName:'InstanceService.search',
                scope:options ? options.scope : undefined
            });
        },
        addInstance:function (instance, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.instance', 'add-instance', {instance:JSON.stringify(instance), serviceContext:{}}, {
                eventName:'InstanceService.addInstance',
                scope:options ? options.scope : undefined
            });
        },
        getInstanceById:function (instanceId, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.instance', 'get-instance-by-id', {instanceId:instanceId, serviceContext:{}}, {
                eventName:'InstanceService.getInstanceById',
                scope:options ? options.scope : undefined
            });
        },
        getInstanceByGroupId:function (groupId, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.instance', 'get-instance-by-group-id', {groupId:groupId, serviceContext:{}}, {
                eventName:'InstanceService.getInstanceByGroupId',
                scope:options ? options.scope : undefined
            });
        },
        updateInstance:function (instance, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.instance', 'update-instance', {instance:JSON.stringify(instance), serviceContext:{}}, {
                eventName:'InstanceService.updateInstance',
                scope:options ? options.scope : undefined
            });
        },
        updateInstanceStatus:function (instanceId, status, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.instance', 'update-instance-status', {instanceId:instanceId, status:status, serviceContext:{}}, {
                eventName:'InstanceService.updateInstanceStatus',
                scope:options ? options.scope : undefined
            });
        }

    }
});