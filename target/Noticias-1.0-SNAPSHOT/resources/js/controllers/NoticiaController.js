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
     
      
       $http({ url: 'noticias/remove', 
                method: 'DELETE', 
                data: {codigo: cod.codigo,
                        titulo: cod.titulo,
                        cuerpo: cod.cuerpo}, 
                headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function(res) {
            $scope.noticias = $scope.noticias.filter(function(noticia){
               return noticia !=cod; 
            });
        }, function(error) {
            console.log(error);
        });
   };
 
});