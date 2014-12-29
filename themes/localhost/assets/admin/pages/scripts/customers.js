var CustomersTools = function () {


    var handleInputMasks = function () {
        $("[data-mask=phone]").inputmask("mask", {
            "mask":"(9999)-999-9999"
        });

        $("[data-mask=credit-card]").inputmask("mask", {
            "mask":"9999-9999-9999-9999"
        });
        $("[data-mask=national-code]").inputmask("mask", {
            "mask":"999-999-9999"
        });
    }

    return {
        //main function to initiate the module
        init:function () {
            handleInputMasks();
        }
    };

}();