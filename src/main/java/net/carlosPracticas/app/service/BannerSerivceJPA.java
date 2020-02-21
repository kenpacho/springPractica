package net.carlosPracticas.app.service;


import net.carlosPracticas.app.model.Banner;
import net.carlosPracticas.app.repository.BannersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BannerSerivceJPA  implements IBannersService{


    @Autowired
    private BannersRepository bannersRepo;


    @Override
    public void insertar(Banner banner) {
        bannersRepo.save(banner);

    }

    @Override
    public List<Banner> buscarActivos(){
        return bannersRepo.findByEstatusOrderByIdDesc("Activo");
    }

    @Override
    public void eliminar(int idBanner){
        bannersRepo.deleteById(idBanner);
    }

    @Override
    public Banner buscarPorId(int idBanner){
        Optional<Banner> optional = bannersRepo.findById((idBanner));
        if(optional.isPresent())
            return optional.get();
        return null;
    }


    @Override
    public List<Banner> buscarTodos() {
        return bannersRepo.findAll();
    }
}
