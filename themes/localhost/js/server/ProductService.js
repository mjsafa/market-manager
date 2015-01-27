MetronicApp.factory("ProductService", function (JsonServer) {
    return {
        search:function (filter, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.product', 'search', {filter:filter, start:0, maxResult:30, serviceContext:{}}, {
                eventName:'ProductService.search',
                scope:options ? options.scope : undefined
            });
        },
        addProduct:function (product, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.product', 'add-product', {product:JSON.stringify(product), serviceContext:{}}, {
                eventName:'ProductService.addProduct',
                scope:options ? options.scope : undefined
            });
        },
        getById:function (productId, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.product', 'get-by-id', {productId:productId, serviceContext:{}}, {
                eventName:'ProductService.getById',
                scope:options ? options.scope : undefined
            });
        },
        updateProduct:function (product, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.product', 'update-product', {product:JSON.stringify(product), serviceContext:{}}, {
                eventName:'ProductService.updateProduct',
                scope:options ? options.scope : undefined
            });
        }
    }
});