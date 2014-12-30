var CustomersTools = function () {


    var handleInputMasks = function () {
        $("[data-mask=phone]").inputmask("mask", {
            "mask":"9999-999-9999"
        });

        $("[data-mask=credit-card]").inputmask("mask", {
            "mask":"9999-9999-9999-9999"
        });
        $("[data-mask=national-code]").inputmask("mask", {
            "mask":"999-999-9999"
        });
    }

    var handlePasswordStrengthChecker = function () {
            var initialized = false;
            var input = $("[pwd-input]");

            input.keydown(function () {
                if (initialized === false) {
                    // set base options
                    input.pwstrength({
                        raisePower: 1.4,
                        minChar: 8,
                        verdicts: ["ضعیف", "عادی", "متوسط", "امن", "بسیار امن"],
                        scores: [17, 26, 40, 50, 60]
                    });

                    // add your own rule to calculate the password strength
                    input.pwstrength("addRule", "demoRule", function (options, word, score) {
                        return word.match(/[a-z].[0-9]/) && score;
                    }, 10, true);

                    // set as initialized
                    initialized = true;
                }
            });
        }


    return {
        //main function to initiate the module
        init:function () {
            handleInputMasks();
            handlePasswordStrengthChecker();
        }
    };

}();