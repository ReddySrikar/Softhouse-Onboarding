app.controller('MainController', ['$scope', 'orders', function($scope, orders) {
    orders.success(function(data) {
        $scope.orderlist = data;
        console.log(data);
    });
}]);