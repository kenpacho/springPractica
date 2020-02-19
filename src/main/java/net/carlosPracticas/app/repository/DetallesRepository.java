package net.carlosPracticas.app.repository;
import net.carlosPracticas.app.model.Detalle;
import net.carlosPracticas.app.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesRepository extends JpaRepository<Detalle, Integer> {

}
