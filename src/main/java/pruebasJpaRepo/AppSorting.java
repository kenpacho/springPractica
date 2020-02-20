package pruebasJpaRepo;
import net.carlosPracticas.app.model.noticia;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.NoticiasRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public class AppSorting {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

            //Obtener todas las entidades ordenadas por un campo.

      //  List<noticia> lista = repo.findAll(Sort.by("titulo").descending());

        //Obtener todas las entidades ordenadas por un campo.

        List<noticia> lista = repo.findAll(Sort.by("fecha").descending().and(Sort.by("titulo").ascending()));
        for(noticia n: lista){
            System.out.println(n);
        }
        context.close();
    }
}
