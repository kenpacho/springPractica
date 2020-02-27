package net.carlosPracticas.app.service;

import net.carlosPracticas.app.model.Perfil;
import net.carlosPracticas.app.repository.PerfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilesServiceJPA implements IPerfilesService {

    @Autowired
    private PerfilesRepository perfilesRepo;

    @Override
    public void guardar(Perfil perfil) {
        perfilesRepo.save(perfil);

    }
}
