package pruebasRelaciones;
import net.carlosPracticas.app.model.Detalle;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.DetallesRepository;

import java.util.List;

public class AppRepoDetalles {
    public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
    DetallesRepository repo = context.getBean("detallesRepository", DetallesRepository.class);

        List<Detalle> lista = repo.findAll();
        for(Detalle d:lista){
            System.out.println(d);
        }

    context.close();
    }
}
