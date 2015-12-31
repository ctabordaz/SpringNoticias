/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticias.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import noticias.domain.Noticia;
import noticias.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author camilo
 */
@Controller
@RequestMapping("/noticias")
public class NoticiasController {
    
     private DataSource dataSource;
    
    @Autowired
    private NoticiaService noticiaService;
    
    @Autowired
    public NoticiasController(DataSource dataSource) {
        System.out.println("++++++++++++++++++++++ constructor");
        this.dataSource  = dataSource;
    }

    @RequestMapping("/noticiaList.json")
    public @ResponseBody List<Noticia> getNoticiaList(){
        System.out.println("++++++++++++++++++++++++++++++get noticias");
        String query = "SELECT * FROM noticia";
        List<Noticia>  NoticiaList = new ArrayList<Noticia>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Noticia not = new Noticia();
                not.setCodigo(rs.getInt("codigo"));
                not.setTitulo(rs.getString("titulo"));
                not.setCuerpo(rs.getString("cuerpo"));
                NoticiaList.add(not);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return NoticiaList;
    };

    
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody void addNoticia(@RequestBody Noticia noticia) {
        noticiaService.addNoticia(noticia);
    };
    
    @RequestMapping("/layout")
    public String getPartialPage() {
        System.out.println("************************"+noticiaService.getAll().get(0).getTitulo());
        return "layouts/noticias";
    };
    
}
