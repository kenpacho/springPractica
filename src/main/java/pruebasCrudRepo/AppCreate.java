package pruebasCrudRepo;
import net.carlosPracticas.app.model.noticia;
import net.carlosPracticas.app.repository.NoticiasRepository;
import  org.springframework.context.support.ClassPathXmlApplicationContext;

  //Aplicacion para persistir (crear) en la tabla de Noticias un obeto de tipo Noticia.
public class AppCreate {
    public static void main (String [] args){

        noticia noticia = new noticia();
        noticia.setTitulo("Próximo Estreno: SAW 8");
        noticia.setDetalle("El mes de septiembre se estrena a nueva entrega de SAW 8");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
        NoticiasRepository repo= context.getBean("noticiasRepository", NoticiasRepository.class);
        repo.save(noticia);

        context.close();
    }
}
