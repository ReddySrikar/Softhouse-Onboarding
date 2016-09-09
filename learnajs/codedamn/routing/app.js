/**
 * Created by Sriram on 9/7/2016.
 */
var app= angular.module("app", ['ngRoute']);
app.config(function($routeProvider){
    $routeProvider
        .when('/',{
            templateUrl:'l11.html'
        })
        .when('/helloUser',{
            templateUrl:'l111.html'
        })
        .otherwise({
            redirect:'/'
        })
});
