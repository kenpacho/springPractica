package net.carlosPracticas.app.controller;

import net.carlosPracticas.app.model.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

    @GetMapping("/create")
    public String crear(){
        return "peliculas/formPelicula";
    }

    @PostMapping("/save")
    public String guardar (Pelicula pelicula){
        return "peliculas/formpelicula";
    }
}
