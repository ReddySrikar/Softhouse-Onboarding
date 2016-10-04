/**
 * Created by Srikar on 04-10-2016.
 */
app.factory('update', ['$http', function($http) {
    return $http.put('http://localhost:8080/api/orders/update/')
        .success(function(data) {
            return data;
        })
        .error(function(err) {
            return err;
        });
}]);

app.factory('reject', ['$http', function($http) {
    return $http.delete('http://localhost:8080/api/orders/delete/')
        .success(function(data) {
            return data;
        })
        .error(function(err) {
            return err;
        });
}]);