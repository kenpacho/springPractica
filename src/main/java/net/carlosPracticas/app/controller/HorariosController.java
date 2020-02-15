package net.carlosPracticas.app.controller;

import net.carlosPracticas.app.model.Horario;
import net.carlosPracticas.app.model.Pelicula;
import net.carlosPracticas.app.service.iPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/horarios")
public class HorariosController {

    @Autowired
    private iPeliculasService servicePeliculas;


    @GetMapping(value = "/create")
    public String crear(@ModelAttribute Horario horario, Model model) {
        List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
        model.addAttribute("peliculas", listaPeliculas);
        return "horarios/formHorario";
    }


    @PostMapping(value="/save")
    public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model){
        if(result.hasErrors()){
            List<Pelicula> listaPeliculasm= servicePeliculas.buscarTodas();
            model.addAttribute("peliculas", listaPeliculasm);
            return "horarios/formHorario";

        }
        System.out.println("Guardando el objeto Horario: " + horario);
        return "redirect/horarios/create";

    }

    @InitBinder("horario")
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }



}


