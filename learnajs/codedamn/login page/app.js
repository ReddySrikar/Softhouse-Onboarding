/**
 * Created by Sriram on 9/7/2016.
 */
var app= angular.module("app", ['ngRoute']);
app.config(function($routeProvider){
    $routeProvider
        .when('/',{
            templateUrl:'l22.html'
        })
        .when('/l33',{
            resolve: {
                "check": function($location,$rootScope){
                    if(!$rootScope.loggedIn){
                        $location.path('/');
                    }
                }

            },
            templateUrl:'l33.html'
        })
        .otherwise({
            redirectTo:'/'
        });
});

app.directive('loginPage',function() {
    return {
        restrict:'E',
        templateUrl:'l22.html',
        controller : function($scope,$location,$rootScope){
            $scope.submit = function(){

                if($scope.username =='admin' && $scope.password =='admin'){
                    $rootScope.loggedIn = true;
                    $location.path('/l33');
                } else{
                    alert('wrong stuff');
                }
            };
        },
controllerAs :'myController'
    };
});




