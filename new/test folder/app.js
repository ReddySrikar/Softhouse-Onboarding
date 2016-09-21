/**
 * Created by Sriram on 9/16/2016.
 */
var myApp = angular.module('myApp',[]);



myApp.directive('tableCreate',function(){
    return{
        restrict:'E',
        templateUrl:'l3.html',
        controller: function($scope) {
            $scope.contacts = [];
            $scope.details = [];
            $scope.singleSelect = [];
            $scope.singleSelect1 = [];

            $scope.add = function() {
                $scope.contacts.push($scope.newcontact);
                $scope.newcontact = "";

                $scope.details.push($scope.newdetail);
                $scope.newdetail = "";

                $scope.singleSelect.push($scope.newoption);
                $scope.newoption = "";

                $scope.singleSelect1.push($scope.newoption1);
                $scope.newoption1 = "";
            }
        },
    controllerAs:'ContactController'
};
});

