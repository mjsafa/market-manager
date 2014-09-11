function callService(service, params, options) {
    var defer = $.Deferred();
    service(params, function (res) {
        if (res == undefined) {
            defer.resolve(undefined);
        } else if (_.has(res, 'exception')) {
            ArmanJsManager.trigger("error:server", res);
            if (options && options.error) {
                options.error(res.exception);
            }
            defer.resolve(undefined);
        } else {
            if (options && options.success) {
                options.success(res);
            }
            defer.resolve(res);
        }
    });
    return defer.promise();
}
function createServiceContext(tags) {
    var context = {
        userId:themeDisplay.getUserId(),
        scopeGroupId:themeDisplay.getScopeGroupId(),
        companyId:themeDisplay.getCompanyId(),
        layoutURL:themeDisplay.getLayoutURL(),
        plid:themeDisplay.getPlid()
    };

    if (tags) {
        context.assetTagNames = tags;
    }

    return JSON.stringify(context)
}

function callServiceByUrl(url, params, callback) {
    callback = callback || {}

    Liferay.Service(url, params,
        function (obj) {
            var key;
            if( (key = typeof obj) !== 'object'){
                callback.error(obj);
            }else {
                callback.success(obj);
            }
            //alert(obj);
        }
    );


}