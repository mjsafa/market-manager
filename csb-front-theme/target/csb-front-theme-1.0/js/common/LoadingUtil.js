var app = app || {};
var loadingKeys = {};


(function () {

    app.loading = {
        begin:function (key) {
            var _key = (!key) ? "global" : key;

            var count = loadingKeys[_key];
            if (!count) {
                count = 0;
            }

            loadingKeys[_key] = count + 1;

            this.updateLoading(_key);
        },

        end:function (key) {
            var _key = (!key) ? "global" : key;

            var count = loadingKeys[_key];
            if (count) {
                loadingKeys[_key] = count - 1;
                this.updateLoading(_key);
            }
        },


        updateLoading:function (key) {
            if(loadingKeys[key] > 0 ){
                this.showLoading(key);
            }else{
                this.hideLoading(key);
            }
        },

        showLoading: function(key){
            $('#' + key).show();
        },

        hideLoading: function(key){
            $('#' + key).hide();
        }

    };

})();