package net.carlosPracticas.app.controller;

import net.carlosPracticas.app.model.Banner;
import net.carlosPracticas.app.service.IBannersService;
import net.carlosPracticas.app.util.utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/banners/")
public class BannersController {

    @Autowired
    private IBannersService serviceBanners;

    @GetMapping("/index")
    public String mostrarInde(Model model){
        List<Banner> banners = serviceBanners.buscarTodos();
        model.addAttribute("banners", banners);
        return "banners/listBanners";
    }

    @GetMapping("/create")
    public String crear(){
        return "banners/formBanner";
    }

    @PostMapping("/save")
    public String guardar(Banner banner, BindingResult result, RedirectAttributes attributes, @RequestParam("archivoImagen")MultipartFile multiPart, HttpServletRequest request){

        if(result.hasErrors()){
            System.out.println("Existieron errores");
            return "banners/formBanner";
        }

        if(!multiPart.isEmpty()){
            String nombreImagen = utiles.guardarImagen(multiPart, request);
            banner.setArchivo(nombreImagen);
        }

        serviceBanners.insertar(banner);
        attributes.addFlashAttribute("mensaje", "El registro fue guardado");
        return "redirect:/banners/index";



    }
}
