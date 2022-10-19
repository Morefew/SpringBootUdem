package com.mycoapp.SpringBootUdem.Controller;
/*
 * @created Sun / Oct / 2022
 * @project SpringBootUdem
 * @author Lenny Gonzalez
 */

import com.mycoapp.SpringBootUdem.Model.EstudianteEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

////// PASANDO DATOS A LA VISTA (HARDCODED) \\\\\\
@Controller // Anotacion que Maneja las peticiones que el EstudianteEntity ha solicitado, los métodos siempre son públicos
@RequestMapping("/estudiante") // URL a mapear por el Controlador, reflejando esas solicitudes
public class EstudianteController {

//    @RequestParam es más útil en una aplicación web tradicional donde los datos se pasan principalmente en los parámetros de consulta, mientras que @PathVariable es más adecuado para servicios web RESTful donde la URL contiene valores.

    //Pasando datos a la vista desde el codigo fuente
    // Metodo 1: usando la clase Model y pasandole una variable de objeto
    // con el @GetMapping() definimos la url de la vista, para el caso /index, /, /home, "".
    @GetMapping(value = {"/index", "/", "/home", ""})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Profesor!, estos son tus Estudiantes.");
        return "index";
    }
    // Metodo 2: Usando la Clase MODEL
    @GetMapping("/perfil")
    public String perfil(Model model) {
        EstudianteEntity estudiante = new EstudianteEntity();
        estudiante.setCedula(56584530825L);
        estudiante.setNombre("Lenny");
        estudiante.setApellido("Gonzalez");
        estudiante.setEscuela("Tecnología");

        //Con los metodos de la Clase Model pasamos los atributos del objeto a la vista
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("titulo", "Perfil de EstudianteEntity ".concat(estudiante.getNombre().concat(" ").concat(estudiante.getApellido())));
        model.addAttribute("", "Perfil de EstudianteEntity ".concat(estudiante.getEscuela()));

        return "perfil_estudiante";
    }

    // Usamos GetMapping cuando un objeto solo se va aplicar en una vista o metodo.
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de EstudianteEntity ");

        return "listar_estudiante";
    }

    //Usamos Model cuando necesitemos presentar y compartir un objeto entre varios metodos y vistas del controlador.
    @ModelAttribute("estudiantes")
    public List<EstudianteEntity> poblarEstudianteEntities() {

        return Arrays.asList(
                new EstudianteEntity(52456654756L,"Georgina", "Dubois", "Tecnología"),
                new EstudianteEntity(82554524428L,"Elaine", "Morris", "Tecnología"),
                new EstudianteEntity(36585545201L,"O'neill", "Fuhller", "Tecnología")
        );
    }


}
 