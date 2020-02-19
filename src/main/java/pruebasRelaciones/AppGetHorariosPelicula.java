package pruebasRelaciones;
import net.carlosPracticas.app.model.Pelicula;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.PeliculasRepository;

import java.util.List;
import java.util.Optional;

public class AppGetHorariosPelicula {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
        PeliculasRepository repo = context.getBean("peliculasRepository", PeliculasRepository.class);

        Optional<Pelicula> optional = repo.findById(7);
        System.out.println(optional.get().getHorarios().size());



        context.close();
    }
}
