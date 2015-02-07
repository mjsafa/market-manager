MetronicApp.controller('UserActivitiesController', ['$rootScope', '$scope', 'UserActivityService', '$state', '$modal', '$filter', function ($rootScope, $scope, UserActivityService, $state, $modal, $filter) {
    $rootScope.settings.layout.pageBodySolid = true;
    $rootScope.settings.layout.pageSidebarClosed = false;

    UserActivityService.search('', '', '', '', {scope:$scope});

    if (!$scope.initialized) {
        $scope.$on('UserActivityService.search', function (event, data) {
            $scope.activities = data.result;
        });
    }
    ;

    $scope.doSearch = function () {
        UserActivityService.search($scope.query || '', $scope.selectedEntity || '',
            $scope.selectedAction || '', $scope.selectedImportance || '', {scope:$scope});
    };

    $scope.importances = [
        {value:1, text:'بالا', className:'label-danger'},
        {value:2, text:'متوسط', className:'label-warning'},
        {value:3, text:'پایین', className:'label-success'}
    ];

    $scope.entities = [
        {value:'Invoice', text:'فاکتور'},
        {value:'InvoiceItem', text:'اقلام فاکتور'},
        {value:'Customer', text:'مشتری'},
        {value:'Score', text:'امتیاز'},
        {value:'User', text:'کاربران'},
        {value:'Payment', text:'پرداخت'},
        {value:'Product', text:'کالا'}
    ];

    $scope.actions = [
        {value:1, text:'افزودن'},
        {value:2, text:'ویرایش'},
        {value:3, text:'حذف'},
        {value:4, text:'تغییر وضعیت'},
        {value:5, text:'دانلود'}
    ];

    $scope.statuses = [
        {value:21, text:'فعال'},
        {value:5, text:'غیر فعال'},
        {value:1, text:'در دست بررسی'},
        {value:0, text:'تایید شده'},
        {value:10001, text:'بسته شده'},
        {value:4, text:'رد شده'}
    ];

    $scope.getName = function (input, data, param) {
        var result = 'none';

        angular.forEach(data, function (object) {
            if (object.value == input) {
                result = object[param];
            }
        });

        return result;
    };

    $scope.showImportance = function (input) {
        return $scope.getName(input, $scope.importances, 'text');
    };

    $scope.showImportanceClass = function (input) {
        return $scope.getName(input, $scope.importances, 'className');
    };

    $scope.showEntity = function (input) {
        return $scope.getName(input, $scope.entities, 'text');
    };

    $scope.showAction = function (input) {
        return $scope.getName(input, $scope.actions, 'text');
    };

    $scope.showStatus = function (input) {
        return $scope.getName(input, $scope.statuses, 'text');
    };

    $scope.getLinkURL = function (entity, data) {
        if (entity == "Invoice") {
            return "invoice/" + data.id;
        }

        if (entity == "InvoiceItem") {
            return "invoice/" + data.invoiceId;
        }


        if (entity == "Customer") {
            return "customer/" + data.id;
        }

        if (entity == "User") {
            return "userDetails/" + data.invoiceId;
        }

        if (entity == "Score") {
            return "customer/" + data.customerId;
        }

        if (entity == "Product") {
            return "products.html";
        }

    }

    $scope.getExplain = function (entity, data, action) {
        if (entity == "InvoiceItem") {
            return "نام جنس: " + data.product.name
                + " - کد جنس: " + data.product.code
                + " - قیمت پایه: " + data.product.basePrice
                + " - تعداد: " + data.number;

        }

        if (entity == "Invoice") {
            if(4 == action) {
                return " تغییر وضیت فاکتور از  "
                       + "\"" + $scope.showStatus(data.oldStatus) + "\""
                       + " به "
                       + "\"" + $scope.showStatus(data.status) + "\"";
            } else {
                return "اطلاعات تا لحظه ثبت: "
                    + "تعداد اقلام : " + data.itemNumber
                    + " - جمع کل هزینه: " + data.totalCost
                    + " - مشتری : " + data.customerName;
            }
        }

        if (entity == "Customer") {
            if (action == 1) {
                return 'مشتری با نام  '
                    + '<strong>'
                    + data.firstName + ' ' + data.lastName
                    + '</strong>'
                    + ' به سامانه افزوده شد.'
                    ;
            }
            if (action == 2) {
                return 'مشتری با نام  '
                    + '<strong>'
                    + data.firstName + ' ' + data.lastName
                    + '</strong>'
                    + ' ویرایش شد.'
                    ;
            } else if (action == 4) {
                return 'وضعیت مشتری با نام  '
                    + '<strong>'
                    + data.firstName + ' ' + data.lastName
                    + '</strong>'
                    + ' به '
                    + ' <span class=\"label font-' + ((data.isActive) ? 'green-jungle' : 'red-flamingo') + '\"> '
                    + ((data.isActive) ? ' فعال' : 'غیر فعال')
                    + '</span>'
                    + '  تغییر یافت'
                    ;
            }
        }

        if (entity == "Score") {
            return   '<strong>' + $filter('score')(data.amount) + '</strong>'
                + ' امتیاز به مشتری با نام '
                + '<strong>'
                + data.firstName + ' ' + data.lastName
                + '</strong>'
                + ' تخصیص یافت. ';
        }

        if (entity == "User") {
            if (action == 1) {
                return 'کاربر با نام  '
                    + '<strong>'
                    + data.firstName + ' ' + data.lastName
                    + '</strong>'
                    + ' به سامانه افزوده شد.'
                    ;
            } else if (action == 4) {
                return 'وضعیت کاربر با نام  '
                    + '<strong>'
                    + data.firstName + ' ' + data.lastName
                    + '</strong>'
                    + ' به '
                    + ' <span class=\"label font-' + ((data.isActive) ? 'green-jungle' : 'red-flamingo') + '\"> '
                    + ((data.isActive) ? ' فعال' : 'غیر فعال')
                    + '</span>'
                    + '  تغییر یافت'
                    ;
            } else if (action == 2) {
                return 'کاربر با نام  '
                    + '<strong>'
                    + data.name
                    + '</strong>'
                    + ' ویرایش شد.'
                    ;

            }
        }

        if (entity == "Payment") {
            if (action == 1) {
                return 'درخواست برداشت به میزان ' +
                    $filter('score')(data.amount) +
                    'امتیاز برای مشتری با نام "' +
                    data.firstName + ' ' + data.lastName +
                    '" ثبت شد. '
            } else if (action == 3) {
                return 'درخواست برداشت به میزان ' +
                    $filter('score')(data.amount) +
                    ' حذف شد.'
            } else if (action == 4) {
                if (data.status == 4) {
                    return 'درخواست برداشت به میزان ' +
                        $filter('score')(data.amount) +
                        ' رد شد. '

                } else if (data.status == 0) {
                    return 'لیست درخواست های در دست بررسی به تعداد ' +
                        data.paymentCount +
                        ' و ارزش ' +
                        data.totalAmount +
                        ' ریال، تایید شد.';
                } else if (data.status == 20) {
                    return 'لیست درخواست های بررسی نشده به تعداد ' +
                        data.paymentCount +
                        ' و ارزش ' +
                        data.totalAmount +
                        ' ریال ، پس از دانلود فایل، به حالت در دست بررسی تغییر یافت.';
                }
                else if (data.status == 1) {
                    return 'کاربر از انجام عملیات روی لیست درخواست های دریافت شده صرف نظر کرد.';
                }
            } else if (action == 5) {
                return 'فایل درخواست های کاربران برای ارائه به بانک دانلود شد.';
            }
        }

        if (entity == "Product") {
            if(4 == action) {
                return "تغییر وضیت کالا با نام "
                    + "\"" + data.name + "\""
                    + " از "
                    + "\"" + $scope.showStatus(data.oldStatus) + "\""
                    + " به "
                    + "\"" + $scope.showStatus(data.status) + "\"";
            } else {
                return "اطلاعات تا لحظه ثبت: "
                    + " نام کالا: " + data.name
                    + " - کد کالا: " + data.code
                    + " - قیمت پایه: " + data.basePrice
                    + "- میزان امتیاز: " + data.score;
            }
        }

    }

    $scope.initialized = true;
}
])
;
