package pruebasJpaRepo;
import com.sun.tools.javac.tree.JCTree;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.NoticiasRepository;

public class AppDeleteAllInBatch {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
        NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

        /* Método deleteAllInBatch de la interfaz JpaRepository --> (más eficiente)
        delete from noticias.
         */

        /*Método deleteAll de la interfaz CrudRepository --> (no es muy eficiente)
            delete from noticias where id=?
            delete from noticias where id=?
            delete from noticias where id=?

         */

        repo.deleteAllInBatch();

        context.close();

    }
}
