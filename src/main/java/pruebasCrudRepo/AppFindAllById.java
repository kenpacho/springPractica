package pruebasCrudRepo;
import net.carlosPracticas.app.model.noticia;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.NoticiasRepository;

import java.util.LinkedList;
import java.util.List;


public class AppFindAllById {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiasRepository repo = context.getBean("noticiaRepository", NoticiasRepository.class);

        //Recuperar varios registros por Id [método FindAllById del repositorio]
        List<Integer> ids = new LinkedList<Integer>();
        ids.add(2);
        ids.add(5);
        ids.add(8);

        Iterable<noticia> it = repo.findAllById(ids);

        for(noticia n: it){
            System.out.println(n);
        }



        context.close();

    }
}
