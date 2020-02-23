package net.carlosPracticas.app.service;

import net.carlosPracticas.app.model.Horario;
import net.carlosPracticas.app.model.Pelicula;
import net.carlosPracticas.app.repository.HorariosRepository;
import net.carlosPracticas.app.repository.PeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class PeliculasServiceJPA implements iPeliculasService{

    @Autowired
    private HorariosRepository horariosRepo;

    @Autowired
    private PeliculasRepository peliculasRepo;

    @Override
    public void insertar(Pelicula pelicula) {
        peliculasRepo.save(pelicula);
    }

    @Override
    public List<Pelicula> buscarPorFecha(Date fecha){
        List<Pelicula>  peliculas= null;
        List<Horario> horarios = horariosRepo.findByFecha(fecha);
        peliculas= new LinkedList<>();

        for(Horario h: horarios){
            peliculas.add(h.getPelicuala());
        }
        return peliculas;
    }

    @Override
    public Page<Pelicula> buscarTodas(org.springframework.data.domain.Pageable page) {
        return peliculasRepo.findAll(page);
    }

    @Override
    public List<Pelicula> buscarTodas() {
        return peliculasRepo.findAll();
    }

    @Override
    public List<Pelicula> buscarActivas(){
        List<Pelicula> peliculas=null;
        peliculas = peliculasRepo.findByEstatus_OrderByTitulo("Activa");
        return peliculas;
    }


    @Override
    public Pelicula buscarPorId(int idPelicula) {
        Optional<Pelicula> optional = peliculasRepo.findById(idPelicula);
        if(optional.isPresent() ){
            return optional.get();
        }
        return null;
    }



    @Override
    public List<String> buscarGeneros() {
        //Esta lista podria ser obtenida de una BBDD
        List<String> generos = new LinkedList<>();
        generos.add("Accion");
        generos.add("Aventura");
        generos.add("Clasicas");
        generos.add("Comedia Romantica");
        generos.add("Drama");
        generos.add("Terror");
        generos.add("Infantil");
        generos.add("Accion y Aventura");
        generos.add("Romantica");
        generos.add("Ciencia Ficcion");
        generos.add("Thriller");

        return generos;
    }

    @Override
    public void eliminar(int idPelicula) {
        peliculasRepo.deleteById(idPelicula);

    }
}
