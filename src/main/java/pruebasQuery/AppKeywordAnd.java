package pruebasQuery;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.NoticiasRepository;

public class AppKeywordAnd {
    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
        NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);


        context.close();
    }
}
