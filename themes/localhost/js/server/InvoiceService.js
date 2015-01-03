MetronicApp.factory("InvoiceService", function (JsonServer) {
   return {
       search:function (filter) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoice', 'search', {filter:filter, start:0, maxResult:30, serviceContext:{}}, {
               eventName:'InvoiceService.search'
           });
       },
       addInvoice:function (invoice) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoice', 'add-invoice', {invoice:JSON.stringify(invoice), serviceContext:{}}, {
               eventName:'InvoiceService.addInvoice'
           });
       },
       getById:function (invoiceId) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoice', 'get-by-id', {invoiceId:invoiceId, serviceContext:{}}, {
               eventName:'InvoiceService.getById'
           });
       },
       updateInvoice:function (invoice) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoice', 'update-invoice', {invoice:JSON.stringify(invoice), serviceContext:{}}, {
               eventName:'InvoiceService.updateInvoice'
           });
       }

   }
});