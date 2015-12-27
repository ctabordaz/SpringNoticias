/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticias.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author camilo
 */
@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
    
    @RequestMapping("/layout")
    public String getPartialPage(){
        
        return "layouts/usuarios";
    }
    
}
