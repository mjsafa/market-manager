/***
 GLobal Directives
 ***/

// Route State Load Spinner(used on page or content load)
MetronicApp.directive('ngSpinnerBar', ['$rootScope',
    function ($rootScope) {
        return {
            link:function (scope, element, attrs) {
                // by defult hide the spinner bar
                element.addClass('hide'); // hide spinner bar by default

                // display the spinner bar whenever the route changes(the content part started loading)
                $rootScope.$on('$stateChangeStart', function () {
                    element.removeClass('hide'); // show spinner bar
                });

                // hide the spinner bar on rounte change success(after the content loaded)
                $rootScope.$on('$stateChangeSuccess', function () {
                    element.addClass('hide'); // hide spinner bar
                    $('body').removeClass('page-on-load'); // remove page loading indicator
                    Layout.setSidebarMenuActiveLink('match'); // activate selected link in the sidebar menu

                    // auto scorll to page top
                    setTimeout(function () {
                        //Metronic.scrollTop(); // scroll to the top on content load
                    }, $rootScope.settings.layout.pageAutoScrollOnLoad);
                });

                // handle errors
                $rootScope.$on('$stateNotFound', function () {
                    element.addClass('hide'); // hide spinner bar
                });

                // handle errors
                $rootScope.$on('$stateChangeError', function () {
                    element.addClass('hide'); // hide spinner bar
                });

                $rootScope.$on('service-call-start', function () {
                    //element.removeClass('hide'); // show spinner bar
                    Metronic.blockUI({
                        animate: true
                    });
                });

                $rootScope.$on('service-call-end', function () {
                    //element.addClass('hide'); // show spinner bar
                    Metronic.unblockUI();
                });

            }
        };
    }
])

// Handle global LINK click
MetronicApp.directive('a', function () {
    return {
        restrict:'E',
        link:function (scope, elem, attrs) {
            if (attrs.ngClick || attrs.href === '' || attrs.href === '#') {
                elem.on('click', function (e) {
                    e.preventDefault(); // prevent link click for above criteria
                });
            }
        }
    };
});

// Handle Dropdown Hover Plugin Integration
MetronicApp.directive('dropdownMenuHover', function () {
    return {
        link:function (scope, elem) {
            elem.dropdownHover();
        }
    };
});

// Handle Dropdown Toggle
MetronicApp.directive('dropdownMenuToggle', function () {
    return {
        link:function (scope, elem) {
            // if you want it to work on click, too:
            elem.dropdown();
        }
    };
});

MetronicApp.directive('ngEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if (event.which === 13) {
                scope.$apply(function () {
                    scope.$eval(attrs.ngEnter);
                });

                event.preventDefault();
            }
        });
    };
});

MetronicApp.directive('emptyToNull', function () {
    return {
        restrict:'A',
        require:'ngModel',
        link:function (scope, elm, attrs, ctrl) {
            ctrl.$parsers.push(function (viewValue) {
                if (viewValue === "")
                    return null;
                return viewValue;
            });
        }
    }
});


MetronicApp.directive('fileUpload', function () {
    return {
        templateUrl: '/delegate/resource/views/my-file-upload.html',
        restrict: 'A',
        scope: {
            uploader: '=uploader',
            isSingle: '@isSingle'
        },
        link: function(scope, element, attrs) {
            element.find('.my-drop-zone').bind ('click', function(){
                element.find('input[type=file]').click();
            });
        }
    }
});