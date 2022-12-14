package com.mycoapp.SpringBootUdem.Controller;/*
 * @created Wed / Oct / 2022
 * @project SpringBootUdem
 * @author Lenny Gonzalez
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    //
    @GetMapping("/")
  public String index(){
        return "params/index";
    }


    @GetMapping("/string")
    public String param(@RequestParam(name="texto", required = false, defaultValue = "Hello Mundo") String texto, Model model){
        model.addAttribute("resultado", "El texto enviado es: "+ texto);
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model){
        model.addAttribute("resultado", "El texto envíado es: "+ saludo + "' y el número es ' " + numero +"'");
        return "params/ver";
    }
}
