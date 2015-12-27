angular.module("noticias",["ngRoute"])
        .config(function($routeProvider){
        
        $routeProvider
        .when("/",{
            controller: "InicioController",
            templateUrl: "layout"
        })
        .when("/noticias",{
            controller: "NoticiaController",
            templateUrl: "noticias/layout"
        });
});