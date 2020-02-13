package net.carlosPracticas.app.service;

import net.carlosPracticas.app.model.Banner;

import java.util.LinkedList;
import java.util.List;

public class BannersServiceImpl implements IBannersService {
    private List<Banner> lista=null;

    public BannersServiceImpl(){
        lista=new LinkedList<>();

        Banner banner1=new Banner();
        banner1.setId(1);
        banner1.setTitulo("Proximamente Kong La Isla Calavera");
        banner1.setArchivo("slide1.jpg");

        Banner banner2=new Banner();
        banner2.setId(2);
        banner2.setTitulo("Estreno La Bella Y La Bestia");
        banner2.setArchivo("slide2.jpg");

        Banner banner3=new Banner();
        banner3.setId(3);
        banner3.setTitulo("Este mes no te pierdas Fast and Furious 8");
        banner3.setArchivo("slide3.jpg");

        Banner banner4=new Banner();
        banner4.setId(4);
        banner4.setTitulo("Estreno en Agosto - Bebe Jefazo");
        banner4.setArchivo("slide4.jpg");

        lista.add(banner1);
        lista.add(banner2);
        lista.add(banner3);
        lista.add(banner4);


    }

    @Override
    public void insertar(Banner banner){
        lista.add(banner);
    }

    @Override
    public List<Banner> buscarTodos(){
        return lista;
    }


}
