var app = app || {};

(function () {

    app.BlogEntriesView = Backbone.View.extend({
        el:$("#BlogList"),

        render:function () {
            this.collection.each(function (entry) {
                var entryView = new app.BlogEntryView({ model:entry });

                entryView.render();
                this.$el.append(entryView.el);
            }, this);
        }
    });

    app.blogEntriesView = new app.BlogEntriesView({collection:app.blogEntries});
})();