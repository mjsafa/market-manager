//this class is an extension to backbone view responsible for handling the view for module Item

var app = app || {};
(function () {

    /**
     * @tag_name: defines module tag name inside HTML code, this will help us to find module tags inside page
     * @options
     * @type {*}
     */
    app.ModuleCollectionView = app.ModuleView.extend({
        itemModule:{},
        itemViewType:undefined,
        //init view to listen on its model change to render it's HTML code

        /**
         * generates item HTML and put or replaces it in the page:
         *      - generate HTML code based on this.model
         *      - hides previously rendered html
         *      - place new elements after last previous element
         *      - removes previous elements
         */
        render:function () {
            var that = this;
            this.prepareViews();

            //previously rendered elements in page
            var previousAllElements = $("[data-collectionIndexId='" + this.indexId + "']");

            previousAllElements.attr('data-collectionIndexId-old', this.indexId);
            previousAllElements = $("[data-collectionIndexId-old='" + this.indexId + "']");

            //last element of previously rendered elements in page
            var previousLastElement = previousAllElements.last().parents("[data-collectionIndexId-old='" + this.indexId + "']");
            if(previousLastElement.length < 1){
                previousLastElement = previousAllElements.last();
            }
            previousAllElements.hide();

            var newHtml = this.generateHTML();
            var newElements = $($.parseHTML(newHtml)).attr('data-collectionIndexId', this.indexId);
            if(previousAllElements.length > 0){

                previousLastElement.after(newElements);
                previousAllElements.remove();
            }else{
                this.moduleTag.after(newElements);
            }

            newElements.last().parent().find("[data-item-page]").on("click", function(e){
                var destinationPage = $(this).attr("data-item-page");
                var location = that.itemModule.baseLink + "/" + $(this).attr("data-item-id");
                if(destinationPage){
                    window.location = destinationPage + "#" + location;
                }else{
                    app.appRouter.navigate(location, {trigger:true, replace: true});
                }
            });
        },

        /**
         * generates html of all views of collection and aggregate theme inside single string value
         * this method only returns the generated code and doesn't put it inside the page
         */
        generateHTML:function () {
            var html = '';
            if(this.views){
                this.views.forEach(function(item){
                    html += item.generateHTML().trim();
                });
            }
            return html;
        },


        initializeData:function(){
            this.options.parse = true;
            this.collection.fetch(this.options);
        },

        prepareViews: function(){
            var that = this;
            this.views = [];

            this.collection.each(function(item){
                if(!that.itemViewType){
                    that.itemViewType = app.ModuleItemView;
                }
                var itemView = new that.itemViewType({
                    model:item
                });

                itemView.template = that.template;
                itemView.moduleTag = that.moduleTag;
                itemView.indexId = that.indexId;

                that.views.push(itemView);
            });
        }
    });

})();