MetronicApp.directive('ngConfirmAction', ['$modal',
    function ($modal) {

        var ModalInstanceCtrl = function ($scope, $modalInstance) {
            $scope.ok = function () {
                $modalInstance.close();
            };

            $scope.cancel = function () {
                $modalInstance.dismiss('cancel');
            };
        };

        return {
            restrict:'A',

            link:function (scope, element, attrs) {
                //scope.ngConfirmMethod = "&";
                element.bind('click', function () {
                    var message = attrs.ngConfirmMessage || "Are you sure ?";
                    var confirmButton = attrs.ngConfirmButton || "تایید";
                    var cancelButton = attrs.cancelButton || "انصراف";
                    //var message = scope[message];
                    /*
                     //This works
                     if (message && confirm(message)) {
                     scope.$apply(attrs.ngReallyClick);
                     }
                     //*/

                    //*This doesn't works
                    var modalHtml = '<div class="modal-body">' + message + '</div>';
                    modalHtml += '<div class="modal-footer"><button class="btn btn-primary" ng-click="ok()">' + confirmButton + '</button><button class="btn btn-warning" ng-click="cancel()">' + cancelButton + '</button></div>';

                    var modalInstance = $modal.open({
                        template:modalHtml,
                        controller:ModalInstanceCtrl
                    });

                    modalInstance.result.then(function () {
                        //scope.ngReallyClick({item:scope.item}); //raise an error : $digest already in progress

                        //scope.$apply(attrs.ngConfirmMethod);
                        scope.$eval(attrs.ngConfirmAction);
                    }, function () {
                        //Modal dismissed
                    });
                    //*/

                });

            }
        }
    }
]);


MetronicApp.directive('scoreInput', function () {
    return {
        require:'ngModel',
        link:function (scope, element, attrs, ngModelController) {
            ngModelController.$parsers.push(function (data) {
                //convert data from view format to model format
                return data * 1000; //converted
            });

            ngModelController.$formatters.push(function (data) {
                //convert data from model format to view format
                var out = data / parseFloat(1000);
                return out; //converted
            });
        }
    }
});


MetronicApp.directive('cardInput', function () {
    return {
        require:'ngModel',
        link:function (scope, element, attrs, ngModelController) {
            if (!ngModelController) return;

            ngModelController.$parsers.push(function (data) {
                //convert data from view format to model format
                var out = data
                if(data.length >= 19){
                    data = data.substr(0, 19);
                }

                if(data){
                    data = data.split("-").join("").split("_").join("");
                    out = data.match(new RegExp('.{1,4}', 'g')).join("-");
                }

                if (ngModelController.$viewValue !== out) {
                    ngModelController.$setViewValue(out);
                    ngModelController.$render();
                }

                return data;
            });

            ngModelController.$formatters.unshift(function (data) {
                //convert data from model format to view format
                var out = data;
                if (data) {
                    out = data.match(new RegExp('.{1,4}', 'g')).join("-");
                }

                return out; //converted
            });

        }
    }
});
