package net.carlosPracticas.app.service;
import net.carlosPracticas.app.model.noticia;

import java.util.List;

public interface iNoticiasService {

        void guardar(noticia noticia);
        List<noticia> buscarUltimas();
        List<noticia> buscarTodas();
        void eliminar(int idNoticia);
        noticia buscarPorId(int idNoticia);
    }
