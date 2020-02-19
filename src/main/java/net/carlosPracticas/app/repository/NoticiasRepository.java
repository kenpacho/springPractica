package net.carlosPracticas.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import net.carlosPracticas.app.model.noticia;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
//public interface NoticiasRepository extends CrudRepository<noticia, Integer> {
public interface NoticiasRepository extends JpaRepository<noticia, Integer> {

        //select * from Noticias.
    List<noticia> findBy();


         //Select + from Noticias where estatus=?
    List<noticia> findByEstatus(String estatus);

        //select * from Noticias where fecha =?.
    List<noticia> findByFecha(Date fecha);

        //select * from Noticias where Estatus=? and Fecha=?
    List<noticia> findByEstatusAndFecha(String estatus, Date fecha);

        //select * from Noticias where Estatus=? or Fecha=?
    List<noticia> findByEstatusOrFecha(String estatus, Date fecha);

        //select * from Noticias where fecha between ? and ?.
    List<noticia> findByFechaBetween(Date fecha1, Date fecha2);

}
