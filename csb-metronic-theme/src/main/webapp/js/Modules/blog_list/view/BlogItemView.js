var app = app || {};

(function(){

    app.BlogItemView = app.ModuleItemView.extend({
        model: new app.BlogEntry()
    });


})();