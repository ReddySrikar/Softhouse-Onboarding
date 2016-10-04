app.controller('MainController', ['$scope', 'orders', '$http', function($scope, orders, $http) {

    orders.success(function (data) {
        $scope.orderlist = data;
        console.log(data);
    });


//app.controller('sendController', ['$scope', '$http', function($scope, $http){
    $scope.default = {};

    $scope.insert = function () {
        var orderdata = $scope.neworder;
        console.log("Hi there!!");
        $http.post("http://localhost:8080/api/orders/", orderdata).success(function (data, status) {
            $scope.hello = orderdata;
            $scope.orderlist.push(orderdata);
        })
    };

    //var employee = $scope.empid;
    $scope.update = function (employid, phmodel, lapmodel) {
        var modelobject = {
            "phmodel": phmodel,
            "lapmodel": lapmodel
        }
        $http.put('http://localhost:8080/api/orders/update/'+employid, modelobject).success(function (data) {
            console.log("Update Successful",employid, modelobject);
        })
    };

    $scope.delete = function (employid) {
        $http.put('http://localhost:8080/api/orders/delete/'+employid).success(function (data) {
            console.log("Delete Successful", data);
        })
    };

    $scope.reset = function () {
        $scope.neworder = angular.copy($scope.default);
    };
}]);