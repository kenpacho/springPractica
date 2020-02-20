package pruebasJpaRepo;
import net.carlosPracticas.app.model.noticia;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.NoticiasRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class AppPaging {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

        //Obtener todas las entidades por paginacion.
       // Page<noticia> page = repo.findAll(PageRequest.of(0, 5));
        //Obtener todas las entidades por paginacion.
        Page<noticia> page = repo.findAll(PageRequest.of(0,10, Sort.by("titulo")));
        for (noticia n :page){
            System.out.println(n);
        }

        context.close();
    }
}
