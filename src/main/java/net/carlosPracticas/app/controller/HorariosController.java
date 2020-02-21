package net.carlosPracticas.app.controller;

import net.carlosPracticas.app.model.Horario;
import net.carlosPracticas.app.model.Pelicula;
import net.carlosPracticas.app.service.IHorariosService;
import net.carlosPracticas.app.service.iPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/horarios")
public class HorariosController {

    @Autowired
    private iPeliculasService servicePeliculas;

    @Autowired
    private IHorariosService serviceHorarios;

    @GetMapping(value="/index")
    public String mostrarIndex(Model model){
        List<Horario> listaHorarios = serviceHorarios.buscarTodos();
        model.addAttribute("horarios", listaHorarios);
        return "horarios/listHorarios";
    }

    @GetMapping(value="/indexPaginate")
    public String mostrarIndexPaginado(Model model, Pageable page){
        Page<Horario> listaHorarios = serviceHorarios.buscarTodos(page);
        model.addAttribute("horarios", listaHorarios);
        return "horarios/listHorarios";
    }


    @GetMapping(value = "/create")
    public String crear(@ModelAttribute Horario horario) {
        return "horarios/formHorario";
    }


    @PostMapping(value="/save")
    public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model, RedirectAttributes attributes){

        if(result.hasErrors()){
            List<Pelicula> listaPeliculasm= servicePeliculas.buscarActivas();
            model.addAttribute("peliculas", listaPeliculasm);
            return "horarios/formHorario";

        }

        serviceHorarios.insertar(horario);
        attributes.addFlashAttribute("msg", "El horario fue guardado!");
        System.out.println("Guardando el objeto Horario: " + horario);
        return "redirect:/horarios/indexPaginate";

    }

    @GetMapping(value = "edit/{id}")
    public String editar(@PathVariable("id") int idHorario, Model model){
        Horario horario = serviceHorarios.buscarPorId(idHorario);
        model.addAttribute("horario", horario);
        return "horarios/formHorario";
    }

    @GetMapping(value = "/delete/{id}")
    public String eliminar(@PathVariable("id") int idHorario, RedirectAttributes attributes){
        serviceHorarios.eliminar(idHorario);
        attributes.addFlashAttribute("msg", "El horario fue eliminado!");
        return "redirect:/horarios/indexPaginate";
    }

    @ModelAttribute("peliculas")
    public List<Pelicula> getPeliculas(){
        return servicePeliculas.buscarActivas();
    }


    @InitBinder("horario")
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }



}


