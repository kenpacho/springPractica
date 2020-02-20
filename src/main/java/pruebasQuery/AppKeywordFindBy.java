package pruebasQuery;
import net.carlosPracticas.app.model.noticia;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.NoticiasRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AppKeywordFindBy {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //Ejemplo de Keyword findBy.

        try {
            List<noticia> lista = repo.findByFecha(format.parse("2019-09-01"));
            for (noticia n : lista) {
                System.out.println(n);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        context.close();

    }
}
