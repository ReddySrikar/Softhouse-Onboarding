/**
 * Created by Sriram on 9/6/2016.
 */
var app= angular.module("app", []);
app.controller("myController", function($scope){
   $scope.country = {
       name:'India',
       flag:'flag.png'
   };
});