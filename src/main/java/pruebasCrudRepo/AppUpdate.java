package pruebasCrudRepo;
import net.carlosPracticas.app.model.noticia;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.NoticiasRepository;

import java.util.Optional;

public class AppUpdate {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiasRepository repo = context.getBean("noticiasRepository",  NoticiasRepository.class);

        //Operación CRUD - Update [método save del repositorio]

        //1. Primero buscamos la endtidad que vamos a modificar (findById).

        Optional<noticia> optional = repo.findById(1);


        //2. Modificamos la entidad y la guardamos.

        if(optional.isPresent()){
            noticia notiicia = optional.get();
            System.out.println(notiicia);
            notiicia.setEstatus("Inactiva");

        }
    }
}
