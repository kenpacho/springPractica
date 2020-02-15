package net.carlosPracticas.app.controller;

import net.carlosPracticas.app.model.Contacto;
import net.carlosPracticas.app.service.iPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ContactoController {

    @Autowired
    iPeliculasService servicePeliculas;

    @GetMapping("/contacto")
    public String mostrarFormulario(@ModelAttribute Contacto contacto, Model model){
        model.addAttribute("generos", servicePeliculas.buscarGeneros());
        model.addAttribute("tipos", tipoNotificaciones());

        return "formContacto";
    }

    @PostMapping("/contacto")
    public String guardar(@ModelAttribute Contacto contacto){
        //Este objeto ya se podria almacenar en BBDD

        System.out.println(contacto);
        return "redirect:/contacto";

    }

    private List<String> tipoNotificaciones(){
        List<String> tipos= new LinkedList<>();
        tipos.add("Estrenos");
        tipos.add("Promociones");
        tipos.add("Noticias");
        tipos.add("Eventos");
        return tipos;
    }

}
