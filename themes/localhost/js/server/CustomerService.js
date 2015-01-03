MetronicApp.factory("CustomerService", function (JsonServer) {
    return{
        search:function (filter) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.customer', 'search', {filter:filter, start:0, maxResult:30, serviceContext:{}}, {
                eventName:'CustomerService.search'
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
        }
    };
});