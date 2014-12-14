var app = app || {};

(function () {
    app.AppRouter = Backbone.Router.extend({

        routes:{
            "post/:id":"initializePost"
        },

        initializePost:function (id) {
            app.modules.blogItem.postId = id;
            app.modules.blogItem.initializeModule();
        }
    });

    app.appRouter = new app.AppRouter();
})();