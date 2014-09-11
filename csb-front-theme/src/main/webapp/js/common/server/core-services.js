var serverAPI = serverAPI || {};
serverAPI.System = {
    Blog:{
        findGroupEntries:function (siteId, first, count, status, callback) {
            var _callback = {};

            if (callback == undefined) {
                _callback = {
                    success:function (res) {
                        return res;
                    },
                    error:function (res) {
                        alert(res);
                    }
                };
            }else{
                _callback = callback;
            }

            callServiceByUrl('/blogsentry/get-group-entries', {
                groupId:siteId,
                status:status,
                start:first,
                end:first + count
            }, _callback);

        }
    }
};