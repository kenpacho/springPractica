package net.carlosPracticas.app.controller;

import net.carlosPracticas.app.model.Pelicula;
import net.carlosPracticas.app.service.iPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
    @Autowired
    private iPeliculasService servicePeliculas;

    @GetMapping("/index")
    public String mostrarIndex (Model model){
        List<Pelicula> lista= servicePeliculas.buscarTodas();
        model.addAttribute("peliculas", lista);
        return"peliculas/listPeliculas";
    }

    @GetMapping("/create")
    public String crear(){
        return "peliculas/formPelicula";
    }

    @PostMapping("/save")
    public String guardar (Pelicula pelicula, BindingResult result, Model model){
        if(result.hasErrors()) {
            System.out.println("Sehan producido errores");
            return "peliculas/formPelicula";

            // for(ObjectError error: result.getAllErrors()){
            //   System.out.println(error.getDefaultMessage());
        }


        servicePeliculas.insertar(pelicula);
        //return "peliculas/formpelicula";
        model.addAttribute("mensaje", "El registro  fue guardado");
        return "redirect:/peliculas/index";
    }
    @InitBinder
    public void initBinder (WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
    }
}
