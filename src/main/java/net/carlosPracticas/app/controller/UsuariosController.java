package net.carlosPracticas.app.controller;


import net.carlosPracticas.app.model.Perfil;
import net.carlosPracticas.app.model.Usuario;
import net.carlosPracticas.app.service.IPerfilesService;
import net.carlosPracticas.app.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private IUsuariosService serviceUsuarios;

    @Autowired
    private IPerfilesService servicePerfiles;

    @GetMapping("/create")
    public String crear(@ModelAttribute Usuario usuario){
        return "usuarios/fromUsuario";
    }

    @GetMapping("/index")
    public String index(){
        return "usuarios/listUsuarios";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Usuario usuario, @RequestParam("perfil") String perfil){
        System.out.println("Usuario: " +  usuario);
        System.out.println("Perfil: " + perfil);

        String tmpPAss = usuario.getPwd();
        String encriptado= encoder.encode(tmpPAss);
        usuario.setPwd(encriptado);
        usuario.setActivo(1);
        serviceUsuarios.guardar(usuario);

        Perfil perfilTmp= new Perfil();
        perfilTmp.setCuenta(usuario.getCuenta());
        perfilTmp.setPerfil(perfil);
        servicePerfiles.guardar(perfilTmp);

        return "redirect:/usuarios/index";
    }

    @GetMapping("/demo-bcrypt")
    public String pruebaBcrypt(){
        String password= "mari123";
        String encriptado = encoder.encode(password);
        System.out.println("Password encriptado: " + encriptado);
        return "usuarios/demo";
    }
}
