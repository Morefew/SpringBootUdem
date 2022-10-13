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


@Controller // Anotacion que Maneja las peticiones que el Usuario ha solicitado, los métodos siempre son públicos
@RequestMapping("/app") // URL a mapear por el Controlador, reflejando esas solicitudes
public class IndexController {

    @GetMapping(value = {"/index", "/", "/home", ""})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework");
        return "index";
    }

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

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Usuario ");

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Georgina", "Dubois", "gdubois@mail.com"),
                new Usuario("Elaine", "Morris", "emorris@mail.com"),
                new Usuario("O'neill", "Fuhller", "ofuhller@mail.com")
        );

        return usuarios;
    }


}
 