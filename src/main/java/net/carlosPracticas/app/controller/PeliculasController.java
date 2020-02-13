package net.carlosPracticas.app.controller;

import net.carlosPracticas.app.model.Pelicula;
import net.carlosPracticas.app.service.iPeliculasService;
import net.carlosPracticas.app.util.utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
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
    public String guardar (Pelicula pelicula, BindingResult result, RedirectAttributes attributes, @RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request){
        if(result.hasErrors()) {
            System.out.println("Se han producido errores");
            return "peliculas/formPelicula";


        }

        if(!multiPart.isEmpty()){
            String nombreImagen= utiles.guardarImagen(multiPart, request);
            pelicula.setImagen(nombreImagen);

        }


        servicePeliculas.insertar(pelicula);
        attributes.addFlashAttribute("mensaje", "El registro  fue guardado");
        return "redirect:/peliculas/index";
    }





    @InitBinder
    public void initBinder (WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
    }
}
