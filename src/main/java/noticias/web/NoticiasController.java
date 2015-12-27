/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticias.web;

import noticias.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author camilo
 */
@Controller
@RequestMapping("/noticias")
public class NoticiasController {
    
    @Autowired
    private NoticiaService noticiaService;

  
    
    @RequestMapping("/layout")
    public String getPartialPage() {
        System.out.println("************************"+noticiaService.getAll().get(0).getTitulo());
        return "layouts/noticias";
    }
    
}
