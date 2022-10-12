package com.mycoapp.SpringBootUdem.Controller;
/*
 * @created Sun / Oct / 2022
 * @project SpringBootUdem
 * @author Lenny Gonzalez
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // Maneja las peticiones que el Usuario a solicitado, los métodos siempre son públicos

@RequestMapping("/app")
public class IndexController {

    @GetMapping(value = {"/index", "/","/home"})
    public String index(Model model){
        model.addAttribute("titulo", "Hola Spring Framework");
    return "index";
    }
}
 