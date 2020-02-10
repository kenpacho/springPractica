package net.carlosPracticas.app.controller;

import net.carlosPracticas.app.model.noticia;
import net.carlosPracticas.app.service.iNoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/noticias")
public class noticiasController {

    @Autowired
    private iNoticiasService serviceNoticias;

    @GetMapping(value="/create")
    public String crear(){
        return "noticias/formNoticia";

    }
@PostMapping(value="/save")
public String guardar(noticia noticia){


        //Pendiente de guardar objeto noticia en la BBDD.

    serviceNoticias.guardar(noticia);




        return "noticias/formNoticia";
}



}
