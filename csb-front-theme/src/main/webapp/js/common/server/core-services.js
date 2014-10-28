var serverAPI = serverAPI || {};
CONFIG = {
		baseUrl : '/api/jsonws'
	};
	
	
serverAPI.System = {
	Blog:{
        findGroupEntries:function (siteName, first, count, status, tags, categories, options) {
            var optionArg = {};
			options.method = "get-latest-blog-entries";
            optionArg.recentDaysCount = options.recentDaysCount;
            return callServiceByUrl(CONFIG.baseUrl + '/csb-modules-service-portlet.myblog/get-latest-blog-entries', {
                "blogName":siteName,
                "status":status,
                "start":first,
                "end":first + count,
                "tags":tags,
                "categories":categories,
                "options":optionArg
            }, options);
        },

        getBlog:function (postId, options) {
            return callServiceByUrl(CONFIG.baseUrl + '/csb-modules-service-portlet.myblog/get-entry', {
                entryId:postId
            }, options);
        }
    }
};