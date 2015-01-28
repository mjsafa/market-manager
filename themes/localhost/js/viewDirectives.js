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
                    modalHtml += '<div class="modal-footer"><button class="btn btn-primary" ng-click="ok()">'+ confirmButton  + '</button><button class="btn btn-warning" ng-click="cancel()">'+ cancelButton  + '</button></div>';

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