/**
 * Created by Sriram on 9/8/2016.
 */
var app= angular.module("app", []);
app.controller("myController", function($scope, $http){
$http.get('http://localhost:63342/on_boarding/learnajs/codedamn/New%20folder%20(3)/database.json?_ijt=b6feekafejqc29nig1ed8c2dqq')
    .success(function(response) {
    $scope.persons = response.records;
        console.log($scope.persons);
    })
});
