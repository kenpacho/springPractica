package net.carlosPracticas.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import net.carlosPracticas.app.model.Banner;
import net.carlosPracticas.app.model.Horario;
import net.carlosPracticas.app.model.noticia;
import net.carlosPracticas.app.service.*;
import net.carlosPracticas.app.util.utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import net.carlosPracticas.app.model.Pelicula;

@Controller
public class HomeController {

	@Autowired
	private IHorariosService serviceHorarios;

	@Autowired
	private IBannersService serviceBanners;

	@Autowired
	private iPeliculasService servicePeliculas;

	@Autowired
	private iNoticiasService serviceNoticias;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM.yyyy");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {

		try {
			Date fechaSinHora =dateFormat.parse(dateFormat.format(new Date()));
			List<String> listaFechas = utiles.getNextDays(4);
			List<Pelicula> peliculas = servicePeliculas.buscarPorFecha(fechaSinHora);
			model.addAttribute("fechas", listaFechas);
			model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
			model.addAttribute("peliculas", peliculas);

		}catch (ParseException e){
			System.out.println("Error: HomeController.mostrarPrincipal" + e.getMessage());
		}
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") Date fecha, Model model) {

		try {
			Date fechaSinHora = dateFormat.parse(dateFormat.format(fecha));
			List<String> listaFechas = utiles.getNextDays(4);
			List<Pelicula> peliculas = servicePeliculas.buscarPorFecha(fechaSinHora);
			model.addAttribute("fechas", listaFechas);
			// Regresamos la fecha que selecciono el usuario con el mismo formato.
			model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
			model.addAttribute("peliculas", peliculas);
			return "home";
		}catch (ParseException e){
			System.out.println("Error: HomeController.buscar" + e.getMessage());
		}
		return "home";
	}




	@RequestMapping(value = "/detail/{id}/{fecha}")
	public String mostrarDetalle(@PathVariable("id") int idPelicula, @PathVariable("fecha") Date fecha, Model model) {
		List<Horario> horarios = serviceHorarios.bucarPorIdPelicula(idPelicula, fecha);
		model.addAttribute("horarios", horarios);
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		return "detalle";
	}

	@RequestMapping(value="/abaut")
	public String mostrarAcerca(){
		return "acerca";
	}

	@RequestMapping(value="/formLogin", method = RequestMethod.GET)
	public String mostrarLogin(){
		return "formLogin";
	}

	@ModelAttribute("noticias")
	public List<noticia> getNoticias(){
		return serviceNoticias.buscarUltimas();
	}

	@ModelAttribute("banners")
	public List<Banner> getBanners(){
		return serviceBanners.buscarActivos();
	}


	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
