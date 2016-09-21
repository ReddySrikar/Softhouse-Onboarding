/**
 * Created by Sriram on 9/16/2016.
 */
var myApp = angular.module('myApp',[]);

myApp.controller('ContactController', ['$scope', function($scope) {
    $scope.contacts = [];
    $scope.details = [];
    $scope.singleSelect = [];
    $scope.singleSelect1 = [];

    $scope.add = function() {
        $scope.contacts.push($scope.newcontact);
        $scope.newcontact = "";
    };
    $scope.add1 = function() {
        $scope.details.push($scope.newdetail);
        $scope.newdetail = "";
    };
    $scope.add2 = function() {
        $scope.singleSelect.push($scope.newoption);
        $scope.newoption = "";
    };
    $scope.add3 = function() {
        $scope.singleSelect1.push($scope.newoption1);
        $scope.newoption1 = "";
    }
}]);

