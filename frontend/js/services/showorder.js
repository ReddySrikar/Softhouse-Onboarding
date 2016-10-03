app.factory('orders', ['$http', function($http) {
    return $http.get('http://localhost:8080/api/orders/all/')
        .success(function(data) {
            return data;
        })
        .error(function(err) {
            return err;
        });
}]);