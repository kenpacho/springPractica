package pruebasQuery;
import net.carlosPracticas.app.model.noticia;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.NoticiasRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AppKeywordAnd {
    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

            //Ejemplo Keyword And.
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<noticia> lista=null;

        try{
            lista = repo.findByEstatusAndFecha("Activa", format.parse("20019--009-088"));
            for(noticia n: lista){
                System.out.println(n);
            }

        }catch (ParseException | NullPointerException e){
            e.printStackTrace();
        }

        context.close();
    }
}
