/***
 Metronic AngularJS App Main Script
 ***/

/* Metronic App */
var MetronicApp = angular.module("MetronicApp", [
    "ui.router",
    "ui.bootstrap",
    "oc.lazyLoad",
    "ngSanitize",
    "xeditable",
    "googlechart"
]);

/* Configure ocLazyLoader(refer: https://github.com/ocombe/ocLazyLoad) */
MetronicApp.config(['$ocLazyLoadProvider', function ($ocLazyLoadProvider) {
    $ocLazyLoadProvider.config({
        cssFilesInsertBefore:'ng_load_plugins_before' // load the above css files before a LINK element with this ID. Dynamic CSS files must be loaded between core and theme css files
    });
}]);

/* Setup global settings */
MetronicApp.factory('settings', ['$rootScope', function ($rootScope) {
    // supported languages
    var settings = {
        layout:{
            pageSidebarClosed:false, // sidebar menu state
            pageBodySolid:false, // solid body color state
            pageAutoScrollOnLoad:1000 // auto scroll to top on page load
        },
        layoutImgPath:Metronic.getAssetsPath() + 'admin/layout/img/',
        layoutCssPath:Metronic.getAssetsPath() + 'admin/layout/css/'
    };

    $rootScope.settings = settings;

    return settings;
}]);

/* Setup App Main Controller */
MetronicApp.controller('AppController', ['$scope', '$rootScope', function ($scope, $rootScope) {
    $scope.$on('$viewContentLoaded', function () {
        Metronic.initComponents(); // init core components
        //Layout.init(); //  Init entire layout(header, footer, sidebar, etc) on page load if the partials included in server side instead of loading with ng-include directive 
    });
}]);

/***
 Layout Partials.
 By default the partials are loaded through AngularJS ng-include directive. In case they loaded in server side(e.g: PHP include function) then below partial
 initialization can be disabled and Layout.init() should be called on page load complete as explained above.
 ***/

/* Setup Layout Part - Header */
MetronicApp.controller('HeaderController', ['$scope', function ($scope) {
    $scope.$on('$includeContentLoaded', function () {
        Layout.initHeader(); // init header
    });
}]);

/* Setup Layout Part - Sidebar */
MetronicApp.controller('SidebarController', ['$scope', function ($scope) {
    $scope.$on('$includeContentLoaded', function () {
        Layout.initSidebar(); // init sidebar
    });
}]);

/* Setup Layout Part - Quick Sidebar */
MetronicApp.controller('QuickSidebarController', ['$scope', function ($scope) {
    $scope.$on('$includeContentLoaded', function () {
        setTimeout(function () {
            QuickSidebar.init(); // init quick sidebar        
        }, 2000)
    });
}]);

/* Setup Layout Part - Theme Panel */
MetronicApp.controller('ThemePanelController', ['$scope', function ($scope) {
    $scope.$on('$includeContentLoaded', function () {
        Demo.init(); // init theme panel
    });
}]);

/* Setup Layout Part - Footer */
MetronicApp.controller('FooterController', ['$scope', function ($scope) {
    $scope.$on('$includeContentLoaded', function () {
        Layout.initFooter(); // init footer
    });
}]);

/* Setup Rounting For All Pages */
MetronicApp.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
    // Redirect any unmatched url
    $urlRouterProvider.otherwise("/dashboard.html");

    $stateProvider

        // Dashboard
        .state('dashboard', {
        url:"/dashboard.html",
        templateUrl:"/delegate/resource/views/dashboard.html",
        data:{pageTitle:'Admin Dashboard Template'},
        controller:"DashboardController",
        resolve:{
            deps:['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load({
                    name:'MetronicApp',
                    files:[
                        '/delegate/resource/assets/global/plugins/morris/morris.css',
                        '/delegate/resource/assets/admin/pages/css/tasks.css',

                        '/delegate/resource/assets/global/plugins/morris/morris.min.js',
                        '/delegate/resource/assets/global/plugins/morris/raphael-min.js',
                        '/delegate/resource/assets/global/plugins/jquery.sparkline.min.js',

                        '/delegate/resource/assets/admin/pages/scripts/index3.js',
                        '/delegate/resource/assets/admin/pages/scripts/tasks.js',

                        '/delegate/resource/js/controllers/DashboardController.js'
                    ]
                });
            }]
        }
    })

        // customers
        .state('customers', {
            url:"/customers.html",
            templateUrl:"/delegate/resource/views/customers.html",
            data:{pageTitle:'لیست مشتریان'},
            controller:"CustomersController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name:'MetronicApp',
                        files:[
                            '/delegate/resource/assets/global/plugins/morris/morris.css',
                            '/delegate/resource/assets/admin/pages/css/tasks.css',
                            '/delegate/resource/assets/global/plugins/jquery-inputmask/jquery.inputmask.bundle.min.js',
                            '/delegate/resource/assets/admin/pages/scripts/customers.js',

                            '/delegate/resource/assets/global/plugins/morris/morris.min.js',
                            '/delegate/resource/assets/global/plugins/morris/raphael-min.js',
                            '/delegate/resource/assets/global/plugins/jquery.sparkline.min.js',
                            '/delegate/resource/js/server/server.js',
                            '/delegate/resource/js/controllers/customer/CustomersController.js',
                            '/delegate/resource/js/controllers/customer/CustomerSelectController.js',
                            '/delegate/resource/js/controllers/customer/CustomerScoreController.js'
                        ]
                    });
                }]
            }
        })


        // customer details
        .state('customerDetail', {
            url:"/customer/:customerId",
            templateUrl:"/delegate/resource/views/customerDetail.html",
            data:{pageTitle:'اطلاعات مشتری'},
            controller:"CustomerDetailController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name:'MetronicApp',
                        files:[
                            '/delegate/resource/assets/global/plugins/morris/morris.css',
                            '/delegate/resource/assets/admin/pages/css/tasks.css',

                            '/delegate/resource/assets/global/plugins/morris/morris.min.js',
                            '/delegate/resource/assets/global/plugins/morris/raphael-min.js',
                            '/delegate/resource/assets/global/plugins/jquery.sparkline.min.js',
                            '/delegate/resource/js/server/server.js',
                            '/delegate/resource/js/controllers/customer/CustomerDetailController.js',
                            '/delegate/resource/js/controllers/customer/CustomerSelectController.js'

                        ]
                    });
                }]
            }
        })


        // USERS
        .state('users', {
            url:"/users.html",
            templateUrl:"/delegate/resource/views/users/users.html",
            data:{pageTitle:'لیست کاربران'},
            controller:"UsersController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name:'MetronicApp',
                        files:[
                            '/delegate/resource/assets/global/plugins/morris/morris.css',
                            '/delegate/resource/assets/admin/pages/css/tasks.css',
                            '/delegate/resource/assets/global/plugins/jquery-inputmask/jquery.inputmask.bundle.min.js',
                            '/delegate/resource/assets/admin/pages/scripts/customers.js',

                            '/delegate/resource/assets/global/plugins/bootstrap-pwstrength/pwstrength-bootstrap.min.js',

                            '/delegate/resource/assets/global/plugins/morris/morris.min.js',
                            '/delegate/resource/assets/global/plugins/morris/raphael-min.js',
                            '/delegate/resource/assets/global/plugins/jquery.sparkline.min.js',
                            '/delegate/resource/js/server/server.js',
                            '/delegate/resource/js/controllers/user/UsersController.js',
                            '/delegate/resource/js/controllers/customer/CustomerSelectController.js',
                            '/delegate/resource/js/controllers/customer/CustomerScoreController.js',
                            '/delegate/resource/js/controllers/GeneralPageController.js'
                        ]
                    });
                }]
            }
        })


        //User Detail
        .state('userDetail', {
            url:"/userDetail/:userId",
            templateUrl:"/delegate/resource/views/users/userDetail.html",
            data:{pageTitle:'جزئیات کاربر'},
            controller:"UserDetailController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name:'MetronicApp',
                        files:[
                            '/delegate/resource/assets/global/plugins/morris/morris.css',
                            '/delegate/resource/assets/admin/pages/css/tasks.css',
                            '/delegate/resource/assets/global/plugins/jquery-inputmask/jquery.inputmask.bundle.min.js',
                            '/delegate/resource/assets/admin/pages/scripts/customers.js',

                            '/delegate/resource/assets/global/plugins/bootstrap-pwstrength/pwstrength-bootstrap.min.js',

                            '/delegate/resource/assets/global/plugins/morris/morris.min.js',
                            '/delegate/resource/assets/global/plugins/morris/raphael-min.js',
                            '/delegate/resource/assets/global/plugins/jquery.sparkline.min.js',
                            '/delegate/resource/js/server/server.js',
                            '/delegate/resource/js/controllers/user/UserDetailController.js',
                            '/delegate/resource/js/controllers/GeneralPageController.js'
                        ]
                    });
                }]
            }
        })


        // customer details
        .state('customerEntry', {
            url:"/customerEntry",
            templateUrl:"/delegate/resource/views/customerEntry.html",
            data:{pageTitle:'ثبت مشتری جدید'},
            controller:"CustomersController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name:'MetronicApp',
                        files:[
                            '/delegate/resource/assets/global/plugins/morris/morris.css',
                            '/delegate/resource/assets/admin/pages/css/tasks.css',

                            '/delegate/resource/assets/global/plugins/morris/morris.min.js',
                            '/delegate/resource/assets/global/plugins/morris/raphael-min.js',
                            '/delegate/resource/assets/global/plugins/jquery.sparkline.min.js',
                            '/delegate/resource/js/server/server.js',
                            '/delegate/resource/js/controllers/customer/CustomersController.js'

                        ]
                    });
                }]
            }
        })


        // AngularJS plugins
        .state('fileupload', {
            url:"/file_upload.html",
            templateUrl:"/delegate/resource/views/file_upload.html",
            data:{pageTitle:'AngularJS File Upload'},
            controller:"GeneralPageController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name:'angularFileUpload',
                            files:[
                                '/delegate/resource/assets/global/plugins/angular/delegate/resource/js/plugins/angular-file-upload/angular-file-upload.min.js',
                            ]
                        },
                        {
                            name:'MetronicApp',
                            files:[
                                '/delegate/resource/js/controllers/GeneralPageController.js'
                            ]
                        }
                    ]);
                }]
            }
        })

        // UI Select
        .state('uiselect', {
            url:"/ui_select.html",
            templateUrl:"/delegate/resource/views/ui_select.html",
            data:{pageTitle:'AngularJS Ui Select'},
            controller:"UISelectController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name:'ui.select',
                            files:[
                                '/delegate/resource/assets/global/plugins/angular/delegate/resource/js/plugins/ui-select/select.min.css',
                                '/delegate/resource/assets/global/plugins/angular/delegate/resource/js/plugins/ui-select/select.min.js'
                            ]
                        },
                        {
                            name:'MetronicApp',
                            files:[
                                '/delegate/resource/js/controllers/UISelectController.js'
                            ]
                        }
                    ]);
                }]
            }
        })

        // UI Bootstrap
        .state('uibootstrap', {
            url:"/ui_bootstrap.html",
            templateUrl:"/delegate/resource/views/ui_bootstrap.html",
            data:{pageTitle:'AngularJS UI Bootstrap'},
            controller:"GeneralPageController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name:'MetronicApp',
                            files:[
                                '/delegate/resource/js/controllers/GeneralPageController.js'
                            ]
                        }
                    ]);
                }]
            }
        })

        // Tree View
        .state('tree', {
            url:"/tree",
            templateUrl:"/delegate/resource/views/tree.html",
            data:{pageTitle:'jQuery Tree View'},
            controller:"GeneralPageController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name:'MetronicApp',
                            files:[
                                '/delegate/resource/assets/global/plugins/jstree/dist/themes/default/style.min.css',

                                '/delegate/resource/assets/global/plugins/jstree/dist/jstree.min.js',
                                '/delegate/resource/assets/admin/pages/scripts/ui-tree.js',
                                '/delegate/resource/js/controllers/GeneralPageController.js'
                            ]
                        }
                    ]);
                }]
            }
        })

        // Form Tools
        .state('formtools', {
            url:"/form-tools",
            templateUrl:"/delegate/resource/views/form_tools.html",
            data:{pageTitle:'Form Tools'},
            controller:"GeneralPageController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name:'MetronicApp',
                            files:[
                                '/delegate/resource/assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.css',
                                '/delegate/resource/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css',
                                '/delegate/resource/assets/global/plugins/jquery-tags-input/jquery.tagsinput.css',
                                '/delegate/resource/assets/global/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css',
                                '/delegate/resource/assets/global/plugins/typeahead/typeahead.css',

                                '/delegate/resource/assets/global/plugins/fuelux/js/spinner.min.js',
                                '/delegate/resource/assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.js',
                                '/delegate/resource/assets/global/plugins/jquery-inputmask/jquery.inputmask.bundle.min.js',
                                '/delegate/resource/assets/global/plugins/jquery.input-ip-address-control-1.0.min.js',
                                '/delegate/resource/assets/global/plugins/bootstrap-pwstrength/pwstrength-bootstrap.min.js',
                                '/delegate/resource/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js',
                                '/delegate/resource/assets/global/plugins/jquery-tags-input/jquery.tagsinput.min.js',
                                '/delegate/resource/assets/global/plugins/bootstrap-maxlength/bootstrap-maxlength.min.js',
                                '/delegate/resource/assets/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js',
                                '/delegate/resource/assets/global/plugins/typeahead/handlebars.min.js',
                                '/delegate/resource/assets/global/plugins/typeahead/typeahead.bundle.min.js',
                                '/delegate/resource/assets/admin/pages/scripts/components-form-tools.js',

                                '/delegate/resource/js/controllers/GeneralPageController.js'
                            ]
                        }
                    ]);
                }]
            }
        })

        // Date & Time Pickers
        .state('pickers', {
            url:"/pickers",
            templateUrl:"/delegate/resource/views/pickers.html",
            data:{pageTitle:'Date & Time Pickers'},
            controller:"GeneralPageController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name:'MetronicApp',
                            files:[
                                '/delegate/resource/assets/global/plugins/clockface/css/clockface.css',
                                '/delegate/resource/assets/global/plugins/bootstrap-datepicker/css/datepicker3.css',
                                '/delegate/resource/assets/global/plugins/bootstrap-timepicker/css/bootstrap-timepicker.min.css',
                                '/delegate/resource/assets/global/plugins/bootstrap-colorpicker/css/colorpicker.css',
                                '/delegate/resource/assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css',
                                '/delegate/resource/assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css',

                                '/delegate/resource/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js',
                                '/delegate/resource/assets/global/plugins/bootstrap-timepicker//delegate/resource/js/bootstrap-timepicker.min.js',
                                '/delegate/resource/assets/global/plugins/clockface//delegate/resource/js/clockface.js',
                                '/delegate/resource/assets/global/plugins/bootstrap-daterangepicker/moment.min.js',
                                '/delegate/resource/assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js',
                                '/delegate/resource/assets/global/plugins/bootstrap-colorpicker//delegate/resource/js/bootstrap-colorpicker.js',
                                '/delegate/resource/assets/global/plugins/bootstrap-datetimepicker//delegate/resource/js/bootstrap-datetimepicker.min.js',

                                '/delegate/resource/assets/admin/pages/scripts/components-pickers.js',

                                '/delegate/resource/js/controllers/GeneralPageController.js'
                            ]
                        }
                    ]);
                }]
            }
        })

        // Custom Dropdowns
        .state('dropdowns', {
            url:"/dropdowns",
            templateUrl:"/delegate/resource/views/dropdowns.html",
            data:{pageTitle:'Custom Dropdowns'},
            controller:"GeneralPageController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name:'MetronicApp',
                            files:[
                                '/delegate/resource/assets/global/plugins/bootstrap-select/bootstrap-select.min.css',
                                '/delegate/resource/assets/global/plugins/select2/select2.css',
                                '/delegate/resource/assets/global/plugins/jquery-multi-select/css/multi-select.css',

                                '/delegate/resource/assets/global/plugins/bootstrap-select/bootstrap-select.min.js',
                                '/delegate/resource/assets/global/plugins/select2/select2.min.js',
                                '/delegate/resource/assets/global/plugins/jquery-multi-select//delegate/resource/js/jquery.multi-select.js',

                                '/delegate/resource/assets/admin/pages/scripts/components-dropdowns.js',

                                '/delegate/resource/js/controllers/GeneralPageController.js'
                            ]
                        }
                    ]);
                }]
            }
        })

        // Advanced Datatables
        .state('datatablesAdvanced', {
            url:"/datatables/advanced.html",
            templateUrl:"/delegate/resource/views/datatables/advanced.html",
            data:{pageTitle:'Advanced Datatables'},
            controller:"GeneralPageController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name:'MetronicApp',
                        files:[
                            '/delegate/resource/assets/global/plugins/select2/select2.css',
                            '/delegate/resource/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css',
                            '/delegate/resource/assets/global/plugins/datatables/extensions/Scroller/css/dataTables.scroller.min.css',
                            '/delegate/resource/assets/global/plugins/datatables/extensions/ColReorder/css/dataTables.colReorder.min.css',

                            '/delegate/resource/assets/global/plugins/select2/select2.min.js',
                            '/delegate/resource/assets/global/plugins/datatables/all.min.js',
                            '/delegate/resource/js/scripts/table-advanced.js',

                            '/delegate/resource/js/controllers/GeneralPageController.js'
                        ]
                    });
                }]
            }
        })

        // Ajax Datetables
        .state('datatablesAjax', {
            url:"/datatables/ajax.html",
            templateUrl:"/delegate/resource/views/datatables/ajax.html",
            data:{pageTitle:'Ajax Datatables'},
            controller:"GeneralPageController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name:'MetronicApp',
                        files:[
                            '/delegate/resource/assets/global/plugins/select2/select2.css',
                            '/delegate/resource/assets/global/plugins/bootstrap-datepicker/css/datepicker.css',
                            '/delegate/resource/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css',

                            '/delegate/resource/assets/global/plugins/bootstrap-datepicker//delegate/resource/js/bootstrap-datepicker.js',
                            '/delegate/resource/assets/global/plugins/select2/select2.min.js',
                            '/delegate/resource/assets/global/plugins/datatables/all.min.js',

                            '/delegate/resource/assets/global/scripts/datatable.js',
                            '/delegate/resource/js/scripts/table-ajax.js',

                            '/delegate/resource/js/controllers/GeneralPageController.js'
                        ]
                    });
                }]
            }
        })

        // User Profile
        .state("profile", {
            url:"/profile",
            templateUrl:"/delegate/resource/views/profile/main.html",
            data:{pageTitle:'User Profile'},
            controller:"UserProfileController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name:'MetronicApp',
                        files:[
                            '/delegate/resource/assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.css',
                            '/delegate/resource/assets/admin/pages/css/profile.css',
                            '/delegate/resource/assets/admin/pages/css/tasks.css',

                            '/delegate/resource/assets/global/plugins/jquery.sparkline.min.js',
                            '/delegate/resource/assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.js',

                            '/delegate/resource/assets/admin/pages/scripts/profile.js',

                            '/delegate/resource/js/controllers/UserProfileController.js'
                        ]
                    });
                }]
            }
        })

        // User Profile Dashboard
        .state("profile.dashboard", {
            url:"/dashboard",
            templateUrl:"/delegate/resource/views/profile/dashboard.html",
            data:{pageTitle:'User Profile'}
        })

        // User Profile Account
        .state("profile.account", {
            url:"/account",
            templateUrl:"/delegate/resource/views/profile/account.html",
            data:{pageTitle:'User Account'}
        })

        // User Profile Help
        .state("profile.help", {
            url:"/help",
            templateUrl:"/delegate/resource/views/profile/help.html",
            data:{pageTitle:'User Help'}
        })

        // Todo
        .state('todo', {
            url:"/todo",
            templateUrl:"/delegate/resource/views/todo.html",
            data:{pageTitle:'Todo'},
            controller:"TodoController",
            resolve:{
                deps:['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name:'MetronicApp',
                        files:[
                            '/delegate/resource/assets/global/plugins/bootstrap-datepicker/css/datepicker3.css',
                            '/delegate/resource/assets/global/plugins/select2/select2.css',
                            '/delegate/resource/assets/admin/pages/css/todo.css',

                            '/delegate/resource/assets/global/plugins/bootstrap-datepicker//delegate/resource/js/bootstrap-datepicker.js',
                            '/delegate/resource/assets/global/plugins/select2/select2.min.js',

                            '/delegate/resource/assets/admin/pages/scripts/todo.js',

                            '/delegate/resource/js/controllers/TodoController.js'
                        ]
                    });
                }]
            }
        })

}]);

/* Init global settings and run the app */
MetronicApp.run(["$rootScope", "settings", "$state", "editableOptions", function ($rootScope, settings, $state, editableOptions) {
    $rootScope.$state = $state; // state to be accessed from view
    editableOptions.theme = 'bs3';
}]);