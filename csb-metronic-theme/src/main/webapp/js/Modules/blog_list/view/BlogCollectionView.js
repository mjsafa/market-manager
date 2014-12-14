var app = app || {};

(function () {

    app.BlogCollectionView = app.ModuleCollectionView.extend({
        itemViewType:app.BlogItemView,
        itemModule:app.modules.blogItem,

        initialize:function () {
            this.collection = new app.BlogEntries();
            this.listenTo(this.collection, "reset sort", this.render);
        }
    });

})();