package pruebasCrudRepo;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.NoticiasRepository;


public class AppCount {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
        NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

        //Contar números de registros en la tala [método count() del repositorio].

        long num = repo.count();
        System.out.println("Se encontraron: " + num + " registros.");


        context.close();
    }
}
