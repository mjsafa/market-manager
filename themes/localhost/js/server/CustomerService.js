MetronicApp.factory("CustomerService", function (JsonServer) {
    return{
        search:function (filter, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'search', {filter:filter ? filter : '', start:0, maxResult:30, serviceContext:{}}, {
                eventName:'CustomerService.search',
                scope:options ? options.scope : undefined
            });
        },
        addCustomer:function (customer) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'add-customer', {customer:JSON.stringify(customer), serviceContext:{}}, {
                eventName:'CustomerService.addCustomer'
            });
        },
        updateCustomer:function (customer) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'update-customer', {customer:JSON.stringify(customer), serviceContext:{}}, {
                eventName:'CustomerService.updateCustomer'
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
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'get-invitees', {customerId:customerId, serviceContext:{}}, {
                eventName:'CustomerService.getInvitees'
            });
        },
        getStats:function (customerId) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'get-stats', {customerId:customerId, serviceContext:{}}, {
                eventName:'CustomerService.getStats'
            });
        },
        getTotalStats:function () {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'get-total-stats', {serviceContext:{}}, {
                eventName:'CustomerService.getTotalStats'
            });
        },
        updateStatus:function (customerId, isActive) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'update-customer-status', {customerId:customerId, isActive:isActive, serviceContext:{}},
                {eventName:'CustomerService.updateStatus'}
            );
        }
    };
});