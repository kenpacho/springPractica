package net.carlosPracticas.app.service;

import net.carlosPracticas.app.model.Pelicula;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface iPeliculasService {
    void insertar(Pelicula pelicula);
    List<Pelicula> buscarTodas();
    Pelicula buscarPorId(int idPelicula);
    List<String> buscarGeneros();
    List<Pelicula> buscarActivas();
    List<Pelicula> buscarPorFecha(Date fecha);
    Page<Pelicula> buscarTodas(Pageable page);
    void eliminar(int idPelicula);

    }




