MetronicApp.factory("PaymentService", function (JsonServer) {
    return{
        search:function (filter, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.payment', 'search', {filter:JSON.stringify(filter) ? filter : {customerId:0}, first:0, maxResult:30, serviceContext:{}}, {
                eventName:'PaymentService.search',
                scope:options ? options.scope : undefined
            });
        },
        addPayment:function (payment , options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.payment', 'add-payment', {paymentMap:JSON.stringify(payment), serviceContext:{}}, {
                eventName:'PaymentService.addPayment',
               scope:options ? options.scope : undefined
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
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.payment', 'get-total-stats', {serviceContext:{}}, {
                eventName:'PaymentService.getTotalStats'
            });
        },
        updateStatus:function (customerId, isActive) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'update-customer-status', {customerId:customerId, isActive:isActive, serviceContext:{}},
                {eventName:'CustomerService.updateStatus'}
            );
        }
    };
});