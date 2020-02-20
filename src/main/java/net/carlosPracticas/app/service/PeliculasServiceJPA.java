package net.carlosPracticas.app.service;

import net.carlosPracticas.app.model.Pelicula;
import net.carlosPracticas.app.repository.PeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class PeliculasServiceJPA implements iPeliculasService{

    @Autowired
    private PeliculasRepository peliculasRepo;

    @Override
    public void insertar(Pelicula pelicula) {
        peliculasRepo.save(pelicula);
    }

    @Override
    public List<Pelicula> buscarTodas() {
        return peliculasRepo.findAll();
    }

    @Override
    public Pelicula buscarPorId(int idPelicula) {
        Optional<Pelicula> optional = peliculasRepo.findById(idPelicula);
        if(optional.isPresent() ){
            return optional.get();
        }
        return null;s
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

        return generos;
    }
}
