MetronicApp.factory("CustomerService", function (JsonServer) {
    return{
        search:function (filter, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'search', {filter:filter, start:0, maxResult:30, serviceContext:{}}, {
                eventName:'CustomerService.search',
                scope: options ? options.scope : undefined
            });
        },
        addCustomer:function (customer) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'add-customer', {customer:JSON.stringify(customer), serviceContext:{}}, {
                eventName:'CustomerService.addCustomer'
            });
        },
        total:function () {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'add-customer', {serviceContext:{}}, {
                eventName:'CustomerService.total'
            });
        },
        getById:function (customerId) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'get-by-id', {customerId:customerId, serviceContext:{}}, {
                eventName:'CustomerService.getById'
            });
        },
        getInvitees:function (customerId) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'get-invitees', {customerId: customerId ,serviceContext:{}}, {
                eventName:'CustomerService.getInvitees'
            });
        }
    };
});