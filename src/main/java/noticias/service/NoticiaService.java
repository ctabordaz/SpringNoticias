/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticias.service;


import java.util.List;
import noticias.domain.Noticia;

/**
 *
 * @author camilo
 */
public interface NoticiaService {
    
    public List<Noticia> getAll();
    
    public void addNoticia(Noticia noticia);
    
    public void removeNoticia(Noticia noticia);
    
}
