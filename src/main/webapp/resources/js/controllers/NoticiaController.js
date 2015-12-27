angular.module("noticias")
.controller("NoticiaController",function($scope,NoticiaService){
  $scope.a = NoticiaService.getAll();
  

});