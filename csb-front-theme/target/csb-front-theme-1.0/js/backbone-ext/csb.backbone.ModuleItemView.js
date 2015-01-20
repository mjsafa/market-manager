//this class is an extension to backbone view responsible for handling the view for module Item

var app = app || {};
(function () {

    /**
     * @tag_name: defines module tag name inside HTML code, this will help us to find module tags inside page
     * @options
     * @type {*}
     */
    app.ModuleItemView = app.ModuleView.extend({

        //init view to listen on its model change to render it's HTML code
        initialize:function () {
            this.listenTo(this.model, "change", this.render);
        },


        initializeData:function(){
            this.model.fetch(this.options);
        },


        /**
         * generates item HTML and put or replaces it in the page:
         *      - generate HTML code based on this.model
         *      - hides previously rendered html
         *      - place new elements after last previous element
         *      - removes previous elements
         */
        render:function () {
            //previously rendered elements in page
            var previousAllElements = $("[data-indexId-item='" + this.indexId + "']");

            //last element of previously rendered elements in page
            var previousLastElement = previousAllElements.last().parents("[data-indexId-item='" + this.indexId + "']");
            if(previousLastElement.length < 1){
                previousLastElement = previousAllElements.last();
            }

            previousAllElements.hide();

            var newHtml = this.generateHTML().trim();
            var newElements = $($.parseHTML(newHtml)).attr('data-indexId-item', this.indexId);

            if(previousAllElements.length > 0){
                previousLastElement.after(newElements);
                previousAllElements.remove();
            }else{
                this.moduleTag.after(newElements);
            }
        },

        /**
         * generates Item HTML using this view's Template
         * this method only returns the generated code and doesn't put it inside the page
         */
        generateHTML:function () {
            var html = _.unescape(this.template(this.model.toJSON()).trim()).trim();
            var elements = $(html);
            elements.find("*").attr("data-item-id", this.model.id);
            elements.attr("data-item-id", this.model.id);
            return $("<div></div>").append(elements.clone()).html();
        }

    });

})();