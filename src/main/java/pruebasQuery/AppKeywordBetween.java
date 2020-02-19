package pruebasQuery;
import net.carlosPracticas.app.model.noticia;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.carlosPracticas.app.repository.NoticiasRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AppKeywordBetween {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
        NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

            //Ejemplo KeywordBetween

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<noticia> lista=null;

        try{
            lista = repo.findByFechaBetween (format.parse("2019-09-08"), format.parse( "2019-10-20"));
            for(noticia n: lista){
                System.out.println(n);
            }
        }catch (ParseException e){
            e.printStackTrace();
        }


        context.close();
    }
}
