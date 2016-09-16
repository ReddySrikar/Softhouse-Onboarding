app.factory('orders', ['$http', function($http) {
    return $http.get('http://localhost:8080/api/users/all/')
        .success(function(data) {
            return data;
        })
        .error(function(err) {
            return err;
        });
}]);