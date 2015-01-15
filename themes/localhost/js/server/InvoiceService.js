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
       },

       ////////// Invoice Item Services ////////////////////
       ////////// Invoice Item Services ////////////////////

       searchItems:function (filter, invoiceId) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoiceitem', 'search', {filter:filter, invoiceId:invoiceId, start:0, maxResult:30, serviceContext:{}}, {
               eventName:'InvoiceItemService.search'
           });
       },
       addInvoiceItem:function (item) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoiceitem', 'add-invoice-item', {invoiceItem:JSON.stringify(item), serviceContext:{}}, {
               eventName:'InvoiceService.addInvoiceItem'
           });
       },
       deleteInvoiceItem:function (invoiceItemId) {
           var result = JsonServer.postByUrl('/csb-modules-service-portlet.invoiceitem', 'delete-invoice-item', {invoiceItemId:JSON.stringify(invoiceItemId), serviceContext:{}}, {
               eventName:'InvoiceService.deleteInvoiceItem'
           });
       }


   }
});