angular.module("noticias")
.factory("NoticiaService",function($http){
    var noticias = {};
    
    noticias.noticiaList = [];
         
    $http.get("http://localhost:8084/AngularSpringApp/railwaystations/railwaystationlist.json")
    .success(function(data){        
        noticias.noticiaList = data;    
     
    })
    .error(function(data,status){
        
    });
        
        console.log( noticias.noticiaList )
    
    return noticias;
            
});