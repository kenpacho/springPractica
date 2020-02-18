package net.carlosPracticas.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import net.carlosPracticas.app.model.noticia;
import org.springframework.stereotype.Repository;


@Repository
//public interface NoticiasRepository extends CrudRepository<noticia, Integer> {
public interface NoticiasRepository extends JpaRepository<noticia, Integer> {
}
