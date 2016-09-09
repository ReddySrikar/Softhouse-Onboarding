/**
 * Created by Sriram on 9/7/2016.
 */
var app= angular.module("app", []);
app.controller("myController", function($scope){
    $scope.employee = [
        {name:'sriram',gender:'male',dateofbirth:new Date('december 18,1993'),salary:26000},
        {name:'srikar',gender:'male',dateofbirth:new Date('november 19,1994'),salary:26000},
        {name:'gopi',gender:'male',dateofbirth:new Date('october 20,1995'),salary:26000},
        {name:'harsha',gender:'male',dateofbirth:new Date('september 21,1996'),salary:26000},
        {name:'charan',gender:'male',dateofbirth:new Date('august 22,1997'),salary:26000},
    ];
    $scope.rowLimit = 3;
});
