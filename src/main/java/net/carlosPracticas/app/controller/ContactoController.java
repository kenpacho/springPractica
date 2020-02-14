package net.carlosPracticas.app.controller;

import net.carlosPracticas.app.model.Contacto;
import net.carlosPracticas.app.service.iPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactoController {

    @Autowired
    iPeliculasService servicePeliculas;

    @GetMapping("/contacto")
    public String mostrarFormulario(@ModelAttribute Contacto contacto, Model model){
        model.addAttribute("generos", servicePeliculas.buscarGeneros());

        return "formContacto";
    }

    @PostMapping("/contacto")
    public String guardar(@ModelAttribute Contacto contacto, Model modelo){
        modelo.addAttribute("generos", servicePeliculas.buscarGeneros());
        return "formContacto";

    }

}
