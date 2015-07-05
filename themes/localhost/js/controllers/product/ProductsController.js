angular.module('MetronicApp').controller('ProductsController', ['$rootScope', '$scope', 'ProductService', '$state', '$modal','$filter', function ($rootScope, $scope, ProductService, $state, $modal,$filter) {
    $rootScope.settings.layout.pageBodySolid = true;
    $rootScope.settings.layout.pageSidebarClosed = false;

    ProductService.search('', -1, {scope: $scope});

    $scope.$on('$viewContentLoaded', function () {
        Metronic.initAjax();
    });

    if (!$scope.initialized) {
        $scope.$on('ProductService.addProduct', function (event, data) {
            $scope.doSearch();
            $rootScope.$emit('page.alert', {message:'کالای جدید در سیستم ثبت شد', type:"success"});
        });

        $scope.$on('ProductService.updateProduct', function (event, data) {
            $scope.doSearch();
            $rootScope.$emit('page.alert', {message:'ویرایش کالا با موفقیت انجام شد', type:"success"});
        });


        $scope.$on('ProductService.search', function (event, data) {
            $scope.products = data.result;
            angular.forEach($scope.products, function(product){
                product.score = $filter('score')(product.score);
            });
        });

        $scope.$on('ProductService.updateProductStatus', function (event, data) {
            $scope.doSearch();
            $rootScope.$emit('page.alert', {message:'بروز رسانی وضعیت کالا به درستی انجام شد.', type:"success"});
        });
    }

    $scope.statuses = [
        {value:21, text:'فعال'},
        {value:5, text:'غیر فعال'}
    ];

    $scope.getName = function (input, data, param) {
        var result = '';

        angular.forEach(data, function (object) {
            if (object.value == input) {
                result = object[param];
            }
        });

        return result;
    };

    $scope.showStatus = function (input) {
        return $scope.getName(input, $scope.statuses, 'text');
    };

    $scope.submitProduct = function (product, id) {
        product.score = product.score*1000;

        if(null != id) {
            product.id = id
            ProductService.updateProduct(product, {scope: $scope});
        } else {
            ProductService.addProduct(product, {scope: $scope});
        }

    };

    $scope.addProduct = function () {
        $scope.inserted = {};

        if(null == $scope.products) {
            $scope.products = {};
        }

        $scope.products.push($scope.inserted);
    };

    $scope.doSearch = function () {
        ProductService.search($scope.query || '', -1, {scope: $scope});
    }

    $scope.doCancel = function (index ,id) {
        if(id == null) {
            $scope.products.splice(index,1);
        }
    }

    $scope.checkString = function (data, name) {
        if(null == data || 2 > data.length) {
            return " حد اقل طول فیلد " + name + " 2 حرف است. "
        }
    }

    $scope.checkNumeric = function (data, name) {
        var pattern = new RegExp("^\\d+$");
        if(!pattern.test(data)) {
            return name + " باید یک عدد مثبت باشد. ";
        }
    }

    $scope.checkFloatingPointNumeric = function (data, name) {
        var pattern = new RegExp("^[0-9]*\.?[0-9]$");
        if(!pattern.test(data) || data<0) {
            return name + " باید یک عدد اعشاری مثبت باشد. ";
        }
    }

    $scope.updateStatus = function(productId ,newStatus) {
        ProductService.updateProductStatus(productId, newStatus, {scope: $scope});
    }

    $scope.initialized = true;
}]);