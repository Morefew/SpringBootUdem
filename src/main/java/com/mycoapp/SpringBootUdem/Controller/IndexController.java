package com.mycoapp.SpringBootUdem.Controller;
/*
 * @created Sun / Oct / 2022
 * @project SpringBootUdem
 * @author Lenny Gonzalez
 */

import com.mycoapp.SpringBootUdem.Model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

////// PASANDO DATOS A LA VISTA (HARDCODED) \\\\\\
@Controller // Anotacion que Maneja las peticiones que el Usuario ha solicitado, los métodos siempre son públicos
@RequestMapping("/app") // URL a mapear por el Controlador, reflejando esas solicitudes
public class IndexController {

//    @RequestParam es más útil en una aplicación web tradicional donde los datos se pasan principalmente en los parámetros de consulta, mientras que @PathVariable es más adecuado para servicios web RESTful donde la URL contiene valores.

    //Pasando datos a la vista desde el codigo fuente
    // Metodo 1: usando la clase Model y pasandole una variable de objeto
    // con el @GetMapping() definimos la url de la vista, para el caso /index, /, /home, "".
    @GetMapping(value = {"/index", "/", "/home", ""})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework");
        return "index";
    }
    // Metodo 2: Usando la Clase MODEL
    @GetMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Andres");
        usuario.setApellido("Gutierrez");
        usuario.setEmail("agutierrez@email.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil de Usuario ".concat(usuario.getNombre().concat(" ").concat(usuario.getApellido())));
        model.addAttribute("", "Perfil de Usuario ".concat(usuario.getEmail()));

        return "perfil";
    }

    // Usamos GetMapping cuando un objeto solo se va aplicar en una vista o metodo.
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Usuario ");

        return "listar";
    }

    //Usamos Model cuando necesitemos presentar y compartir un objeto entre varios metodos y vistas del controlador.
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {

        return Arrays.asList(
                new Usuario("Georgina", "Dubois", "gdubois@mail.com"),
                new Usuario("Elaine", "Morris", "emorris@mail.com"),
                new Usuario("O'neill", "Fuhller", "ofuhller@mail.com")
        );
    }


}
 