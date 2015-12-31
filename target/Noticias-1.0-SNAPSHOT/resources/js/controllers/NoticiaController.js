angular.module("noticias")
.controller("NoticiaController",function($scope,$http){
  $scope.titulo = "Noticias :D";
  $scope.newNoticia = {};
    $http.get("noticias/noticiaList.json")
    .success(function (data) {
        $scope.noticias = data;

    })
    .error(function (data, status) {

    });
    
   $scope.guardar = function(){
       
       $http.post("noticias/add",{          
           titulo: $scope.newNoticia.titulo,
           cuerpo: $scope.newNoticia.cuerpo
       }).success(function(data){
            
       $scope.noticias.push($scope.newNoticia);
       $scope.newNoticia = {};
           
       });
      
       
   };
   
   $scope.remove = function(cod){
    //   $http.delete("noticias/")
   };
 
});