MetronicApp.factory("CustomerService", function (JsonServer) {
    return{
        search:function (filter , mentorCustomerId, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'search', {filter: filter ? filter : '', mentorCustomerId : mentorCustomerId ? mentorCustomerId : 0,
                    start:0, maxResult:30, serviceContext:{}}, {
                eventName:'CustomerService.search',
                scope:options ? options.scope : undefined
            });
        },
        addCustomer:function (customer, options) {
            var _customer = {};
            angular.copy(customer, _customer);
            _customer.expireDate = _customer.expireDate.getTime();
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'add-customer', {customer:JSON.stringify(_customer), serviceContext:{}}, {
                eventName:'CustomerService.addCustomer',
                scope:options ? options.scope : undefined
            });
        },
        updateCustomer:function (customer, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'update-customer', {customer:JSON.stringify(customer), serviceContext:{}}, {
                eventName:'CustomerService.updateCustomer' ,
                scope:options ? options.scope : undefined
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
        updateStatus:function (customerId, isActive, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'update-customer-status', {customerId:customerId, isActive:isActive, serviceContext:{}},
                {eventName:'CustomerService.updateStatus',
                    scope:options ? options.scope : undefined
                }
            );
        }
    };
});