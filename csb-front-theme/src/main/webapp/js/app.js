/*global $ */
/*jshint unused:false */
var app = app || {};
var ENTER_KEY = 13;
var ESC_KEY = 27;
var application = application || undefined;
$(function () {
    // kick things off by creating the `App`
    if ((!application) || (!application.initialized)) {
        application = new app.AppView();
    }

    //application.initialize();


});