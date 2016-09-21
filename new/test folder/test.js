/**
 * Created by Sriram on 9/17/2016.
 */
angular.module('staticSelect', [])
    .controller('ExampleController', ['$scope', function($scope) {
        $scope.data = {
            singleSelect: null,
            multipleSelect: [],
            option1: 'option'
        };

        $scope.forceUnknownOption = function() {
            $scope.data.singleSelect = 'nonsense';
        };
    }]);