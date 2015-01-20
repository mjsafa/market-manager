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

    var formModule = app.Module.extend({
	
		tagName:"form-module",
		dataSelector:'*[data-form]',

        //the url of item page will look like '/somePage.html#post/:id'
        
        moduleViews:[],
        initializeModuleView:function (tag) {
            this.options = {};

            var indexId = tag.attr("data-indexId");

            //prepare common tag props
            this.commonTagProperties(tag, this.options);

            //initializing options from tag
            this.options.siteName = GetterUtil.getAttributeByDefault(tag, 'data-site-name', 'Guest');
			this.options.formName = GetterUtil.getAttributeByDefault(tag, 'data-form-name', '');
			this.options.serviceContext = {};
			this.options.fieldsMap = {};

			this.options.success = function(res) {
				app.EventBus.trigger('form:' + that.options.formName + ':success' , res);
				app.EventBus.trigger('form:' + that.options.formName + ':complete', res);
			};
			
			this.options.error = function(res) {
				app.EventBus.trigger('form:' + that.options.formName + ':error' , res);
				app.EventBus.trigger('form:' + that.options.formName + ':complete' , res);
			};

			
			var that = this;
			tag.find('*[data-submit]').click(function(e){
				var inputs = tag.find('*[data-field]');
				inputs.each(function(index){
					that.options.fieldsMap[$(this).attr('data-field')] = $(this).val();
				});
				
				serverAPI.System.Form.addRecord(that.options.siteName, that.options.formName, that.options.fieldsMap, that.options.serviceContext, that.options);
			});
            
			
        }


    });

    app.modules.formModule = new formModule();

})();