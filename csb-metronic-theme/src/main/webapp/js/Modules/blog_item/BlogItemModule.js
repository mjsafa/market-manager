var app = app || {};


/*
 * TAG Attributes :
 *   - blog-name
 *   - categories
 *   - tags
 *   - count
 *   - imageSize (in which size load main image)
 *
 *
 * */
(function () {

    var blogItemModule = app.Module.extend({

        tagName:"blogPost",

        //the url of item page will look like '/somePage.html#post/:id'
        baseLink:"post",
        moduleViews:[],
        initializeModuleView:function (tag) {
            this.options = {};

            var indexId = tag.attr("data-indexId");

            //prepare common tag props
            this.commonTagProperties(tag, this.options);

            //initializing options from tag
            this.options.imageSize = GetterUtil.getAttribute(tag, 'image-size');
            if (!this.options.imageSize) {
                this.options.imageSize = ImageSize.BIG; //Set default image size to BIG
            }

            //initialize related view
            var itemView = new app.BlogItemView();
            itemView.options = this.options;
            itemView.moduleTag = tag;
            itemView.indexId = indexId;

            this.options.postId = this.postId;

            this.moduleViews.push(itemView);
        }


    });

    app.modules.blogItem = new blogItemModule();

})();