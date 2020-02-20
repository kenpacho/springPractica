package pruebasCrudRepo;
import net.carlosPracticas.app.model.noticia;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.NoticiasRepository;

import java.util.Optional;

public class AppRead {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(("WEB-INF/spring/root-context.xml"));
        NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

        //Operacion CRUD - Read [método findById del repositorio]

        Optional<noticia> noticia = repo.findById(1);
        System.out.println(noticia);


        context.close();
    }


}
