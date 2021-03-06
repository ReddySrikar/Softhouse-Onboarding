/**
 * Created by Sriram on 9/8/2016.
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
            templateUrl:'index.html'
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
                    alert('f u ');
                }
            };
        },
        controllerAs :'myController'
    };
});
app.directive('pageFooter', function(){
   return {
       restrict:'E',
       templateUrl:'footer.html',
       controller: function($scope){
           $scope.contacts = [
               {city:'Stockholm',name:'softhouse consulting', address:'Tegnérgatan 37',pin:'SE-111 61 Stockholm'
                   ,phonenumber:'+46841092950', mail:'info.stockholm@softhouse.se'},
               {city:'Göteborg',name:'softhouse consulting', address:'Magasinsgatan 18A',pin:'411 18 Göteborg'
                   ,phonenumber:'+46317609900',mail:'info.goteborg@softhouse.se'},
               {city:'Malmö',name:'softhouse consulting', address:'Willans Park 3',pin:'SE-352 30 Växjö'
                   ,phonenumber:'+46455618700',mail:'info.vaxjo@softhouse.se'},
               {city:'Karlskrona',name:'softhouse consulting', address:'Trg Solidarnosti 2A',pin:'71 000 Sarajevo'
                   ,phonenumber:'+387644279847',mail:'info.bosnia@softhouse.se'},
               {city:'Växjö',name:'softhouse consulting', address:'Willans Park 3',pin:'SE-352 30 Växjö'
                   ,phonenumber:'+46455618700', mail:'info.vaxjo@softhouse.se'},
               {city:'Sarajevo',name:'softhouse consulting', address:'Trg Solidarnosti 2A',pin:'71 000 Sarajevo'
                   ,phonenumber:'+387644279847', mail:'info.bosnia@softhouse.se'}]
       },
     controllerAs:'ref'
   };
});
app.directive('heaDer',function(){
    return {
        restrict : 'E',
        templateUrl : 'header.html',
        controller : function($scope){
            $scope.head1 = {mainheading:'Softhouse',subheading:'softhouse employee section'};
            $scope.head2= {mainheading:'Mobiles',subheading:'softhouse mobile section'};
            $scope.head3= {mainheading:'Laptops',subheading:'softhouse Laptops section'};

        },
        controllerAs : 'headerCTRL'
    };
});

app.directive('orderTable',function(){
   return {
    restrict:'E',
       templateUrl:'index.html'
   };
});

