package net.carlosPracticas.app.controller;

import net.carlosPracticas.app.model.Contacto;
import net.carlosPracticas.app.service.iPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ContactoController {

    @Autowired
    iPeliculasService servicePeliculas;

    @GetMapping("/contacto")
    public String mostrarFormulario(@ModelAttribute("instanciaContacto") Contacto contacto){
        return "formContacto";
    }

    @GetMapping("/contacto")
    public String guardar(@ModelAttribute("instanciaContacto") Contacto contacto, RedirectAttributes attributes){
        // El objeto de modelo contacto podria ser almacenadoo en la BBDD.
        System.out.println("Guardando datos del usuario: " + contacto);
        attributes.addFlashAttribute("msg", "Gracias por enviarnos tu opinión!");
        return "redirect:/contacto";
    }

    @ModelAttribute("generos")
    public List<String> getGeneros(){
        return servicePeliculas.buscarGeneros();
    }

}
