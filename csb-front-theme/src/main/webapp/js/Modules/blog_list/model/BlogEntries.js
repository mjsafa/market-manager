/*global Backbone */
var app = app || {};

(function () {
    'use strict';

    // Blog Entry Collection
    // ---------------

    // The collection of blog entries is backed by a remote server.
    app.BlogEntries = Backbone.Collection.extend({
        // Reference to this collection's model.
        model:app.BlogEntry,


        sync:function (method, model, options) {
            switch (method) {
                case 'read':
                    var result = serverAPI.System.Blog.findGroupEntries(options.blogName, options.start, options.count, 0 , options.tags , options.categories, options);
                    return result;
                case 'create':
                case 'delete':
                case 'update':
                case 'patch':
                    return Backbone.sync(method, model, options);
            }
        },

        parse:function (res) {
            if (res.length == 0) {
            } else {
            }
            return res;
        },

        render:function () {
            _.each(this.collection.models, function (blogEntry) {
                $(this.el).append(new app.BlogEntryView({model:blogEntry}).render().el);
            }, this);
            return this;
        },


        comparator:'date'
    });

    // Create our global collection of **Blog Entries**.
    app.blogEntries = new app.BlogEntries();
})();