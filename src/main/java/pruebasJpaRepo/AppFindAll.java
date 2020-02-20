package pruebasJpaRepo;
import net.carlosPracticas.app.model.noticia;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.NoticiasRepository;

import java.util.List;

public class AppFindAll {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

        //Obtener todas las entidades [método findAll]

        List<noticia> lista = repo.findAll();
        for(noticia n : lista)
            System.out.println(n);

        context.close();
    }

}
