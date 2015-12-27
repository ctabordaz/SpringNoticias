angular.module("noticias")
.factory("NoticiaService",function($http){
    var noticias = {};
    
    noticias.getAll = function(){
        $http.get("noticias/noticiaList.json")
                .success(function(data){
                    return data;
                })
                .error(function(error){
                    console.log(error);
                    return error;
                });
    }
    
    return noticias;
            
})