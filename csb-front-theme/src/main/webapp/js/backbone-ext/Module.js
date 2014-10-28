var app = app || {};


(function () {

    app.Module = Backbone.Router.extend({
        initialized:false,
        tagName:"",
        namespace:"module",
        moduleViews:[],

        routes:{

        },

        initializeModule:function () {
            var that = this;
            this.moduleViews = [];
            //var selectedTags = $(this.namespace + "\\:" + this.tagName);
            var selectedTags = $("script[data-modulename='" + this.tagName + "']");
            selectedTags.each(function (index) {

                //adds an index id to the data attribute of the tag to separate this instance from other similar tags
                $(this).attr('data-indexId', that.tagName + "_" + index);

                //this method must be implemented in Each module class. eg. BlogModule, Forum Module and etc.
                that.initializeModuleView($(this));
            });

            this.moduleViews.forEach(function (moduleView) {
                moduleView.initializeView();
            });

            this.initialized = true;
        },

        commonTagProperties:function (tag, options) {
            var loadingKey = GetterUtil.getAttribute(tag, "loadingTarget")
            options.loadingKey = loadingKey;

            var that = options;
            options.success = function (res) {
                app.loading.end(that.loadingKey);
            }

            options.error = function (res) {
                app.loading.end(that.loadingKey);
            }
        }

    });

    app.modules = {};
})();