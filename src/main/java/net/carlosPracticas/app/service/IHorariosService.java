package net.carlosPracticas.app.service;

import net.carlosPracticas.app.model.Horario;

import java.util.Date;
import java.util.List;

public interface IHorariosService {
    List<Horario> bucarPorIdPelicula(int idPelicula, Date fecha);
}
