MetronicApp.factory("ProductService", function (JsonServer) {
    return {
        search:function (filter, status, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.product', 'search', {filter:filter, status:status, start:0, maxResult:30, serviceContext:{scopeGroupId:scopeGroupId}}, {
                eventName:'ProductService.search',
                scope:options ? options.scope : undefined
            });
        },
        addProduct:function (product, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.product', 'add-product', {product:JSON.stringify(product), serviceContext:{scopeGroupId:scopeGroupId}}, {
                eventName:'ProductService.addProduct',
                scope:options ? options.scope : undefined
            });
        },
        getById:function (productId, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.product', 'get-by-id', {productId:productId, serviceContext:{scopeGroupId:scopeGroupId}}, {
                eventName:'ProductService.getById',
                scope:options ? options.scope : undefined
            });
        },
        updateProduct:function (product, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.product', 'update-product', {product:JSON.stringify(product), serviceContext:{scopeGroupId:scopeGroupId}}, {
                eventName:'ProductService.updateProduct',
                scope:options ? options.scope : undefined
            });
        },
        updateProductStatus:function (productId, status, options) {
            var result = JsonServer.postByUrl('/csb-modules-service-portlet.product', 'update-product-status', {productId:productId, status:status, serviceContext:{scopeGroupId:scopeGroupId}}, {
                eventName:'ProductService.updateProductStatus',
                scope:options ? options.scope : undefined
            });
        }

    }
});