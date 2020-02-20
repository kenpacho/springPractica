package pruebasCrudRepo;
import net.carlosPracticas.app.model.noticia;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.NoticiasRepository;

public class AppFindAll {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

        //Recuperar todos los registros [método findAll del repositorio].

        Iterable <noticia> it = repo.findAll();

        for(noticia n: it){
            System.out.println(n);
        }


        context.close();
    }


}
