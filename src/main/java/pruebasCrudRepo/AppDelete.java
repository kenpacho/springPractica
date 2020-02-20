package pruebasCrudRepo;
import net.carlosPracticas.app.repository.NoticiasRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppDelete {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

        // Operación CRUD - Delete [método deleteById del repositorio]

        int idNoticia = 1;
       // repo.deleteById(idNoticia);
        if(repo.existsById(idNoticia)){
            repo.deleteById(idNoticia);
        }

        context.close();
    }
}
