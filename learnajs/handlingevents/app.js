/**
 * Created by Sriram on 9/7/2016.
 */
var app= angular.module("app", []);
app.controller("myController", function($scope){
    $scope.technologies = [
     {name:'c',likes:0,dislikes:0},
     {name:'c++',likes:0,dislikes:0},
     {name:'csharp',likes:0,dislikes:0},
     {name:'java',likes:0,dislikes:0}
    ];
    $scope.incrementLikes = function(technologies){
        technologies.likes++;
    };
    $scope.decrementDislikes = function(technologies) {
      technologies.dislikes++;
    };
});
