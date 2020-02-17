package pruebasjpa;
import net.carlosPracticas.app.repository.NoticiasRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppExists {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
        NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

        // Método para verificar si una entidad existe en la BBDD (método existsById).

        int idNoticia = 1;
        System.out.println(repo.existsById(idNoticia));

        context.close();

    }
}
