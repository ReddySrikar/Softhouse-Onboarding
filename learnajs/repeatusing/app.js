/**
 * Created by Sriram on 9/6/2016.
 */
var app= angular.module("app", []);
app.controller("myController", function($scope){
    $scope.countries = [
        {
            name:'UK',
            cities:[
                {city:'Hyderabad'},
                {city:'Vizag'},
                {city:'guntur'}
            ]
        },
        {
            name:'Sweden',
            cities:[
                {city:'karlskrona'},
                {city:'ronneby'},
                {city:'goteberg'}
            ]
        },
        {
            name:'Australia',
            cities:[
                {city:'Melbourne'},
                {city:'Sidney'},
                {city:'Brisbane'}
            ]
        }

    ];

    $scope.employees =[
    {firstName:'sriram',lastName:'varma',gender:'male',age:'23'},
    {firstName:'srikar',lastName:'reddy',gender:'male',age:'22'},
    {firstName:'gopi',lastName:'dalasari',gender:'male',age:'21'},
    {firstName:'harsha',lastName:'jns',gender:'male',age:'20'}
];

});
