MetronicApp.factory("PaymentService", function (JsonServer) {
    return{
        search:function (filter, options) {
            var _filter = angular.copy(filter, _filter);
            if(_filter){
                if(_filter.fromDate){
                    _filter.fromDate = _filter.fromDate.getTime();
                }
                if(_filter.toDate){
                    _filter.toDate = _filter.toDate.getTime();
                }
            }
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.payment', 'search', {filter:_filter ? _filter : {customerId:0}, first:filter.first, maxResult:filter.maxResults, serviceContext:{}}, {
                eventName:'PaymentService.search',
                scope:options ? options.scope : undefined
            });
        },
        addPayment:function (payment, options) {
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
        },

        isDownloaded:function (options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.payment', 'is-downloaded', { serviceContext:{}},
                {
                    eventName:'PaymentService.isDownloaded',
                    scope:options ? options.scope : undefined
                }
            );
        },

        downloadPayments:function (options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.payment', 'download-payments', { serviceContext:{}},
                {
                    eventName:'PaymentService.downloadPayments',
                    scope:options ? options.scope : undefined
                }
            );
        },
        cancelDownloadPayments:function (options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.payment', 'cancel-download-payments', { serviceContext:{}},
                {
                    eventName:'PaymentService.cancelDownloadPayments',
                    scope:options ? options.scope : undefined
                }
            );
        },

        acceptPayments:function (options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.payment', 'accept-payments', {serviceContext:{}},
                {
                    eventName:'PaymentService.acceptPayments',
                    scope:options ? options.scope : undefined
                }
            );
        },

        deletePayment:function (paymentId, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.payment', 'delete-payment', {paymentId:paymentId, serviceContext:{}},
                {
                    eventName:'PaymentService.deletePayment',
                    scope:options ? options.scope : undefined
                }
            );
        },

        getStats:function (customerId, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.payment', 'get-stats', {customerId:customerId, serviceContext:{}},
                {
                    eventName:'PaymentService.getStats',
                    scope:options ? options.scope : undefined
                }
            );
        },

        rejectPayment:function (paymentId, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.payment', 'reject-payment', {paymentId:paymentId, serviceContext:{}},
                {
                    eventName:'PaymentService.rejectPayment',
                    scope:options ? options.scope : undefined
                }
            );
        }

    };
});