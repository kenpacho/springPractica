package net.carlosPracticas.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import net.carlosPracticas.app.service.BannersServiceImpl;
import net.carlosPracticas.app.service.IBannersService;
import net.carlosPracticas.app.service.iPeliculasService;
import net.carlosPracticas.app.util.utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.carlosPracticas.app.model.Pelicula;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	private IBannersService serviceBanners;

	@Autowired
	private iPeliculasService servicePeliculas;

	private SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM.yyyy");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model){
		List<String> listaFechas = utiles.getNextDays(4);

		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners", serviceBanners.buscarTodos());
		return "home";
	}



	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {

		List<String> listaFechas = utiles.getNextDays(4);

		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners", serviceBanners.buscarTodos());


		return "home";
	}

	@RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	//@RequestMapping(value = "/detail", method = RequestMethod.GET)

	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha) {
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));

		return "detalle";
	}


}
