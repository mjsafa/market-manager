//this class is an extension to backbone view responsible for handling the view for module Item

var app = app || {};
(function () {

    /**
     * @tag_name: defines module tag name inside HTML code, this will help us to find module tags inside page
     * @options
     * @type {*}
     */
    app.ModuleView = Backbone.View.extend({
        moduleTag:undefined,

        //useful to distinguish between multiple module instances inside one page, this id is used
        // to mark generated HTML code by module
        indexId:0,

        //The object that contains data about this item such as query parameters, etc.
        options:{},

        //JQUERY object for <Script> Tag for module template
        // This object is initialized by moduleTag in  initializeModule function
        template:{},

        //this function must be overridden by user to parse tag and generate options object
        parseTag:function () {

        },


        initializeData:function(){

        },



        /*
        Initializes this module View {
         - Parses Module Tag attributes and creates the options object
         - Converts Modules Tag to <Script> Tag
         - Fetch Module Data
         - Renders the module
         }

        this is different than initialize function so that client can write his own code for that init method

        this function is called only when this view is related to a single item module (like User profile)
        */
        initializeView:function () {
            this.parseTag();
            this.moduleTag.attr('data-indexId', this.indexId).attr('type',"text/template");
            this.initializeData();
            this.template = _.template(_.unescape(this.moduleTag.html()));
        }

    });

})();