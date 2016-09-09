/**
 * Created by Sriram on 9/8/2016.
 */
var app= angular.module("app", []);
app.controller("myController", function($scope){
    $scope.counter=0;
    $scope.$watch('myText', function(newValue, oldValue){
        console.log("New Value :" +newValue);
        console.log("Old Value :" +newValue);
    });

});
