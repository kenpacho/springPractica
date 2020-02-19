package pruebasQuery;
import net.carlosPracticas.app.model.noticia;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.NoticiasRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AppKeywordOr {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root--context.xml");
        NoticiasRepository repo= context.getBean("noticiasrepository", NoticiasRepository.class);

            //Ejmeplo Keyword OR.

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<noticia> lista=null;

        try{
            lista = repo.findByEstatusOrFecha("Inactiva", format.parse("2019-09-08"));
            for(noticia  n: lista){
                System.out.println(n);
            }

        }catch (ParseException  | NullPointerException e ){
            e.printStackTrace();
        }

        context.close();
    }
}
