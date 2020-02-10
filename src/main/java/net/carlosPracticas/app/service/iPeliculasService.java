package net.carlosPracticas.app.service;

import net.carlosPracticas.app.model.Pelicula;

import java.util.List;

public interface iPeliculasService {
    List<Pelicula> buscarTodas();
    Pelicula buscarPorId(int idPelicula);

    }




