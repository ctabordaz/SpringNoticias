/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticias.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import noticias.domain.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author camilo
 */
@Service("noticiaService")
public class NoticiaServiceImp implements NoticiaService{
    
    private DataSource dataSource;
    private static List<Noticia> NoticiaList = new ArrayList<Noticia>();
    private static  int Nnoticia = 0;
    @Autowired
    public NoticiaServiceImp(DataSource dataSource) {
        this.dataSource  = dataSource;     
        System.out.println("++++++++++++++++++++++++++++++get noticias");
        String query = "SELECT * FROM noticia";
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
    }
    
    
    
    @Override
    public List<Noticia> getAll() {
     
        return this.NoticiaList;
    }

    @Override
    public void addNoticia(Noticia noticia) {
        
        noticia.setCodigo(Nnoticia);
        
        
         Connection conn=null;
         System.out.println("creando********************************************************");
        
        try{
            conn= dataSource.getConnection();
            conn.setAutoCommit(false);
            
            String sqlUsers = "INSERT INTO noticia (codigo, titulo, cuerpo) VALUES("+ noticia.getCodigo()+",'"+ noticia.getTitulo()+"','"+noticia.getCuerpo()+"');";
            PreparedStatement psUsers = conn.prepareStatement(sqlUsers);
            psUsers.executeUpdate();
            psUsers.close();
           
            conn.commit();
            NoticiaList.add(noticia);
            NoticiaServiceImp.Nnoticia++;
        }catch(SQLException e){
            
            throw new RuntimeException(e);
            
        }finally{
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){} 
                
            }
        }
        
      
        
        
       
    }

    @Override
    public void removeNoticia(Noticia noticia) {
        
         Connection conn=null;
         System.out.println("eliminado********************************************************");
        
        try{
            conn= dataSource.getConnection();
            conn.setAutoCommit(false);
            
            String sqlUsers = "DELETE FROM noticia WHERE codigo = "+noticia.getCodigo() +";";
           
            PreparedStatement psUsers = conn.prepareStatement(sqlUsers);
            psUsers.executeUpdate();
            psUsers.close();
           
            conn.commit();
            if (NoticiaList.contains(noticia)) {
            NoticiaList.remove(noticia);
             }
            
        }catch(SQLException e){
            
            throw new RuntimeException(e);
            
        }finally{
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){} 
                
            }
        }
        
    }
    
}
