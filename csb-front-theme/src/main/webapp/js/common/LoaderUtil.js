var app = app || {};
var moduleState = {};
var getKeys = function (obj) {
    var keys = [];
    for (var key in obj) {
        keys.push(key);
    }
    return keys;
}

app.baseURL = "/delegate/resource"

app.EventBus = _.extend({}, Backbone.Events);

(function () {
    app.loader = {
        isLoaded:false,

        notReady:function (key) {
            if (!moduleState[key]) {
                moduleState[key] = 1;
            } else {
                moduleState[key] += 1;
            }
        },

        ready:function (key) {
            if (!moduleState[key]) {
                app.EventBus.trigger('ready:' + key);
            } else {
                if (moduleState[key] > 0) {
                    moduleState[key] -= 1;
                    if (moduleState[key] == 0) {
                        moduleState[key] = undefined;
                        app.EventBus.trigger('ready:' + key);
                    }
                } else {
                    moduleState[key] = undefined;
                    app.EventBus.trigger('ready:' + key);
                }
            }

            var keys = getKeys(moduleState);
            var count = 0;
            keys.forEach(function (index) {
                if (moduleState[index]) {
                    count += 1;
                }
            });

            if (count == 0) {
                app.EventBus.trigger("ready:all");
            }
        },

        loadScript: function(script){
            $.getScript(app.baseURL + "/"  + script);
        }
    }

})();