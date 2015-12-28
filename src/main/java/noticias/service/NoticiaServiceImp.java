/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticias.service;

import java.util.ArrayList;
import java.util.List;
import noticias.domain.Noticia;
import org.springframework.stereotype.Service;

/**
 *
 * @author camilo
 */
@Service("noticiaService")
public class NoticiaServiceImp implements NoticiaService{
    
    private static List<Noticia> NoticiaList = new ArrayList<Noticia>();

    public NoticiaServiceImp() {
        Noticia n1 = new Noticia();
        n1.setCodigo(0);
        n1.setTitulo("Primera notica");
        n1.setCuerpo("LALALALALALALALLALALALLALA");
        
        Noticia n2 = new Noticia();
        n2.setCodigo(1);
        n2.setTitulo("Segunda notica");
        n2.setCuerpo("BOBOBOBOBOBOBOBOBOOBOBOBOOB");
        
        NoticiaList.add(n1);
        NoticiaList.add(n2);
    }
    
    
    
    @Override
    public List<Noticia> getAll() {
     return NoticiaList;
    }

    @Override
    public void addNoticia(Noticia noticia) {
        NoticiaList.add(noticia);
    }

    @Override
    public void removeNoticia(Noticia noticia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
