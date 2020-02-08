package net.carlosPracticas.app.controller;

import net.carlosPracticas.app.model.noticia;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/noticias")
public class noticiasController {

    @GetMapping(value="/create")
    public String crear(){
        return "noticias/formNoticia";

    }
@PostMapping(value="/save")
public String guardar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String estatus, @RequestParam("detalle") String detalle){

        noticia noticia = new noticia();
        noticia.setTitulo(titulo);
        noticia.setEstatus(estatus);
        noticia.setDetalle(detalle);

        //Pendiente de guardar objeto noticia en la BBDD.




        return "noticias/formNoticia";
}



}
