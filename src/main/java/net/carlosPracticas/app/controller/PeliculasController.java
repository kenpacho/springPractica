package net.carlosPracticas.app.controller;

import net.carlosPracticas.app.model.Pelicula;
import net.carlosPracticas.app.service.IDetalleService;
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
    private IDetalleService serviceDetalles;

    @Autowired
    private iPeliculasService servicePeliculas;

    @GetMapping("/index")
    public String mostrarIndex (Model model){
        List<Pelicula> lista= servicePeliculas.buscarTodas();
        model.addAttribute("peliculas", lista);
        return"peliculas/listPeliculas";
    }

    @GetMapping("/create")
    public String crear(@ModelAttribute Pelicula pelicula, Model model) {
        return "peliculas/formPelicula";
    }

    @PostMapping("/save")
    public String guardar (@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes, @RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request){
        if(result.hasErrors()) {
            System.out.println("Se han producido errores");
            return "peliculas/formPelicula";

        }

        if(!multiPart.isEmpty()){
            String nombreImagen= utiles.guardarImagen(multiPart, request);
            pelicula.setImagen(nombreImagen);

        }


        serviceDetalles.insertar(pelicula.getDetalle());

        servicePeliculas.insertar(pelicula);
        attributes.addFlashAttribute("mensaje", "El registro  fue guardado");
        return "redirect:/peliculas/index";
    }

    @GetMapping(value="/edit/{id}")
    public String editar(@PathVariable("id") int idPelicula, Model model){
        Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula);
        model.addAttribute("pelicula", pelicula);
        return "peliculas/formPelicula";
    }

    @GetMapping(value="/delete/{id}")
    public String eliminar(@PathVariable("id") int idPelicula, RedirectAttributes attributes){

        Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula);

        servicePeliculas.eliminar(idPelicula);

        serviceDetalles.eliminar(pelicula.getDetalle().getIid());

        attributes.addFlashAttribute("mensaje", "La película fue eliminada!");
        return "redirect:/peliculas/index";
    }

    @ModelAttribute("generos")
    public List<String> getGeneros(){
        return servicePeliculas.buscarGeneros();
    }

    @InitBinder
    public void initBinder (WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
    }
}
