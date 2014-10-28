/*global Backbone, jQuery, _, ENTER_KEY */
var app = app || {};

(function ($) {
	'use strict';

	app.AppView = Backbone.View.extend({

		el: '#myapp',

		initialize: function () {
            app.loader.notReady("global");
            app.modules.blog.initializeModule();
            Backbone.history.start();
            this.initialized = true;
            app.loader.ready("global");
		}
	});
})(jQuery);