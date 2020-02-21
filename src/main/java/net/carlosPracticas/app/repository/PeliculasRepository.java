package net.carlosPracticas.app.repository;

import net.carlosPracticas.app.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculasRepository extends JpaRepository<Pelicula, Integer> {

    public List<Pelicula> findByEstatus_OrderByTitulo(String estatus);

}
