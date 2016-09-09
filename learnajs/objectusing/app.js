/**
 * Created by Sriram on 9/6/2016.
 */
var app= angular.module("app", []);
app.controller("myController", function($scope){
     $scope.employee = {
         name :'sriram',
         age :'24',
         gender:'male'
     };
    $scope.message="AngularJS tutorial";
});

