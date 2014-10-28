var app = app || {};


/*
 * TAG Attributes :
 *   - blog-name
 *   - categories
 *   - tags
 *   - count: default to 20
 *   - imageSize (in which size load main image)
 *   - recentDaysCount: for example you want to get posts of the last 3 days
 *
 *
 * */
(function () {

    var blogModule = app.Module.extend({

        tagName:"blogPosts",
        moduleViews:[],

        initializeModuleView:function (tag) {
            this.options = {
                start:0
            };

            var indexId = tag.attr("data-indexId");

            //prepare common tag props
            this.commonTagProperties(tag, this.options);

            //initializing options from tag
            this.options.blogName = GetterUtil.getAttribute(tag, 'blog-name');
            this.options.tags = GetterUtil.getAttributeByDefault(tag, 'tags', '');
            this.options.categories = GetterUtil.getAttributeByDefault(tag, 'categories' , '');
            this.options.count = GetterUtil.getAttributeByDefault(tag, 'count', 20);
            this.options.imageSize = GetterUtil.getAttributeByDefault(tag, 'image-size', ImageSize.BIG);
            this.options.recentDaysCount = GetterUtil.getAttributeByDefault(tag, 'recentDaysCount', 0);

            //create the view object for this instance of TAG
            var itemView = new app.BlogCollectionView({
                options:this.options,
                moduleTag:tag,
                indexId:indexId
            });
            itemView.options = this.options;
            itemView.moduleTag = tag;
            itemView.indexId = indexId;

            this.moduleViews.push(itemView);
        }
    });

    app.modules.blog = new blogModule();

})();