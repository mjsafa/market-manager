/*global Backbone, jQuery, _, ENTER_KEY, ESC_KEY */
var app = app || {};

(function ($) {
	'use strict';

	app.BlogEntryView = Backbone.View.extend({
		//... is a list tag.
		tagName:  'div',

		// Cache the template function for a single item.
		template: _.template($('#blog-post-template').html()),

		initialize: function () {

		},

		render: function () {
			this.$el.html(this.template(this.model.toJSON()));
			return this;
		},

		toggleVisible: function () {
			this.$el.toggleClass('hidden', this.isHidden());
		},

		// Remove the item, destroy the model from *localStorage* and delete its view.
		clear: function () {
			this.model.destroy();
		}
	});
})(jQuery);