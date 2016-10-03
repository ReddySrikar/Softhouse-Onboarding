app.controller('MainController', ['$scope', 'orders', '$http', function($scope, orders, $http) {
    orders.success(function(data) {
        $scope.orderlist = data;
        console.log(data);
    });
}]);

app.controller('sendController', ['$scope', '$http', function($scope, $http){
    $scope.default = {};

    $scope.insert = function () {
        var orderdata = $scope.neworder;
        console.log("Hi there!!");
        $http.post("http://localhost:8080/api/orders/", orderdata).success(function(data, status) {
            $scope.hello = orderdata;
        })
    };

    $scope.reset = function () {
        $scope.neworder = angular.copy($scope.default);
    };
}]);