package net.carlosPracticas.app.service;

import net.carlosPracticas.app.model.Pelicula;

import java.util.List;

public interface iPeliculasService {
    void insertar(Pelicula pelicula);
    List<Pelicula> buscarTodas();
    Pelicula buscarPorId(int idPelicula);
    List<String> buscarGeneros();
    void eliminar(int idPelicula);

    }




