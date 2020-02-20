package net.carlosPracticas.app.service;

import net.carlosPracticas.app.model.Horario;
import net.carlosPracticas.app.repository.HorariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HorariosServiceJpa implements IHorariosService {

    @Autowired
    private HorariosRepository horariosRepo;

    @Override
    public List<Horario> bucarPorIdPelicula(int idPelicula, Date fecha) {

        return horariosRepo.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);

    }
}
