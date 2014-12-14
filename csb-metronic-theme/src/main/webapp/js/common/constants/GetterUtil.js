var GetterUtil = {
    getAttribute:function (jqueryObject, attributeName) {
        var result = jqueryObject.attr(attributeName);
        if (!result) {
            return undefined;
        } else {
            return result;
        }
    },

    getAttributeByDefault:function (jqueryObject, attributeName, defaultValue) {
        var result = jqueryObject.attr(attributeName);
        if (!result) {
            return defaultValue;
        } else {
            return result;
        }
    }
};