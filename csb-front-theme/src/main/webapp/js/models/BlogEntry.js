/*global Backbone */
var app = app || {};

(function () {
	'use strict';

	// Todo Model
	// ----------


	app.BlogEntry = Backbone.Model.extend({
		// Default attributes for the Blog Entry
		// and ensure that each todo created has `title` and 'content'  keys.
		defaults: {
			title: Language.blog.UNTITLED,
            content : ''
		}

	});
})();