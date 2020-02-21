package net.carlosPracticas.app.controller;

import net.carlosPracticas.app.model.Pelicula;
import net.carlosPracticas.app.service.IDetalleService;
import net.carlosPracticas.app.service.iPeliculasService;
import net.carlosPracticas.app.util.utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
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
import java.awt.print.Pageable;
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

    @GetMapping(value="/indexPaginate")
    public String mostrarIndexPaginado(Model model, Pageable page){
        Page<Pelicula> lista = servicePeliculas.buscarTodas(page);
        model.addAttribute("peliculas", lista);
        return "peliculas/listPeliculas";
    }

    @GetMapping("/create")
    public String crear(@ModelAttribute Pelicula pelicula) {
        return "peliculas/formPelicula";
    }

    @PostMapping("/save")
    public String guardar (@ModelAttribute Pelicula pelicula, BindingResult result, Model model, @RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request, RedirectAttributes attributes){
        if(result.hasErrors()) {

            System.out.println("Se han producido errores");
            return "peliculas/formPelicula";

        }

        if(!multiPart.isEmpty()){
            String nombreImagen= utiles.guardarImagen(multiPart, request);
            if(nombreImagen!=null){
                pelicula.setImagen(nombreImagen);
            }
        }

        serviceDetalles.insertar(pelicula.getDetalle());

        servicePeliculas.insertar(pelicula);
        attributes.addFlashAttribute("msg", "Los datos de la pelicula fueron guardados!");
        return "redirect:/peliculas/indexPaginate";
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
        return "redirect:/peliculas/indexPaginate";
    }

    @ModelAttribute("generos")
    public List<String> getGeneros(){
        return servicePeliculas.buscarGeneros();
    }

    @InitBinder
    public void initBinder (WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
    }
}
