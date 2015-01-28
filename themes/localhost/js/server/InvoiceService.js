MetronicApp.factory("InvoiceService", function (JsonServer) {
   return {
       search:function (filter, status, customerId, options) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoice', 'search', {filter:filter, status:status, customerId:customerId, start:0, maxResult:30, serviceContext:{}}, {
               eventName:'InvoiceService.search',
               scope:options ? options.scope : undefined
           });
       },
       addInvoice:function (invoice, options) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoice', 'add-invoice', {invoice:JSON.stringify(invoice), serviceContext:{}}, {
               eventName:'InvoiceService.addInvoice',
               scope:options ? options.scope : undefined
           });
       },
       getById:function (invoiceId, options) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoice', 'get-by-id', {invoiceId:invoiceId, serviceContext:{}}, {
               eventName:'InvoiceService.getById',
               scope:options ? options.scope : undefined
           });
       },
       updateInvoice:function (invoice, options) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoice', 'update-invoice', {invoice:JSON.stringify(invoice), serviceContext:{}}, {
               eventName:'InvoiceService.updateInvoice',
               scope:options ? options.scope : undefined
           });
       },
       updateInvoiceStatus:function (invoiceId, status, options) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoice', 'update-invoice-status', {invoiceId:invoiceId, status:status, serviceContext:{}}, {
               eventName:'InvoiceService.updateInvoiceStatus',
               scope:options ? options.scope : undefined
           });
       },

       ////////// Invoice Item Services ////////////////////
       ////////// Invoice Item Services ////////////////////

       searchItems:function (filter, invoiceId, options) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoiceitem', 'search', {filter:filter, invoiceId:invoiceId, start:0, maxResult:30, serviceContext:{}}, {
               eventName:'InvoiceItemService.search',
               scope:options ? options.scope : undefined
           });
       },
       addInvoiceItem:function (item, options) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoiceitem', 'add-invoice-item', {invoiceItem:JSON.stringify(item), serviceContext:{}}, {
               eventName:'InvoiceService.addInvoiceItem',
               scope:options ? options.scope : undefined
           });
       },
       deleteInvoiceItem:function (invoiceItemId, options) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoiceitem', 'delete-invoice-item', {invoiceItemId:JSON.stringify(invoiceItemId), serviceContext:{}}, {
               eventName:'InvoiceService.deleteInvoiceItem',
               scope:options ? options.scope : undefined
           });
       }


   }
});