package net.carlosPracticas.app.service;


import net.carlosPracticas.app.model.noticia;
import net.carlosPracticas.app.repository.NoticiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiasServiceJPA implements iNoticiasService {


    @Autowired
    private NoticiasRepository noticiasRepo;


    @Override
    public void guardar(noticia noticia) {
        noticiasRepo.save(noticia);

    }



    @Override
    public List<noticia> buscarUltimas() {
        List<noticia> noticias = noticiasRepo.findTop3ByEstatusOrderByIdDesc("Activa");
        return noticias;
    }



    @Override
    public List<noticia> buscarTodas() {
        return noticiasRepo.findAll();
    }

    @Override
    public void eliminar(int idNoticia) {
        noticiasRepo.deleteById(idNoticia);

    }


    @Override
    public noticia buscarPorId(int idNoticia) {
        Optional<noticia> optional = noticiasRepo.findById(idNoticia);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
