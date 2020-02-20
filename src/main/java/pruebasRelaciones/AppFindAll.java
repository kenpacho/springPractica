package pruebasRelaciones;
import net.carlosPracticas.app.model.Pelicula;
import net.carlosPracticas.app.repository.PeliculasRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AppFindAll {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");

                //Recuperar todas las entidades de tipo Pelicula.
        PeliculasRepository repo = context.getBean("peliculasRepository", PeliculasRepository.class);
        List<Pelicula> lista = repo.findAll();
        for(Pelicula p :lista){
            System.out.println(p);
        }

        context.close();
    }
}
