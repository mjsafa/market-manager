/*global Backbone */
var app = app || {};

(function () {
    'use strict';

    // Blog Entry Collection
    // ---------------

    // The collection of blog entries is backed by a remote server.
    var BlogEntries = Backbone.Collection.extend({
        // Reference to this collection's model.
        model:app.BlogEntry,


        sync:function (method, model, options) {
            switch (method) {
                case 'read':
                    alert(options);
                    return serverAPI.System.Blog.findGroupEntries(options.siteId, options.first, options.first + options.count , 0);
                case 'create':
                case 'delete':
                case 'update':
                case 'patch':
                    return Backbone.sync(method, model, options);
            }
        },

        parse:function (res) {
            if (res.length == 0){
                //BlogEntries.activityDates.minDate = Activity.activityDates.maxDate = undefined;
            }else {
            }
            return res;
        },
        comparator:'date'
    });

    // Create our global collection of **Blog Entries**.
    app.blogEntries = new BlogEntries();
})();