ArmanJsManager.module('Common', function (Common, ArmanJsManager, Backbone, Marionette, $, _) {
    Common.Controllers = {
        loading: function (options) {
            ArmanJsManager.mainRegion.show(new ArmanJsManager.Common.Views.Loading(options));
        }
    }
});
