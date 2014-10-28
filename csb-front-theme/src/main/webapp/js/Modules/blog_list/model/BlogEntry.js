/*global Backbone Application */
var app = app || {};

(function () {
    'use strict';

    app.BlogEntry = Backbone.Model.extend({
        idAttribute:'id',
        defaults:{
            title:Language.blog.UNTITLED,
            content:''
        },

        sync:function (method, model, options) {
            switch (method) {
                case 'read':
                    var result = serverAPI.System.Blog.getBlog(options.postId, options);
                    return result;
                case 'create':
                case 'delete':
                case 'update':
                case 'patch':
                    return Backbone.sync(method, model, options);
            }
        },

        parse:function (res) {
          //alert(res);
            if(!res.image){
                res.image = {url: '_NO_LINK'};
            }

            //parse the content
            if(res.content){
                try{
                    var parsedContent = JSON.parse(res.content);
                    res.content = parsedContent;
                }catch(e){
                }
            }
            return res;
        }


    });
})();