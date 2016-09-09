/**
 * Created by Sriram on 9/8/2016.
 */
var App= angular.module("myApp", []);
App.service('random', function(){
    var num = Math.floor(Math.random()*10);
    this.generate = function(){
        return num;
    };
});
App.controller("myController", function($scope,random){
$scope.generateRandom = function(){
    $scope.randomNumber = random.generate();
};
});
