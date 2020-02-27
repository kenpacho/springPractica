package net.carlosPracticas.app.service;

import net.carlosPracticas.app.model.Usuario;
import net.carlosPracticas.app.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceJPA implements IUsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepo;

    @Override
    public void guardar(Usuario usuario) {
        usuariosRepo.save(usuario);

    }
}
