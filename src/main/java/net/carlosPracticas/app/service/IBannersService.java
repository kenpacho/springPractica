package net.carlosPracticas.app.service;

import net.carlosPracticas.app.model.Banner;

import java.util.List;

public interface IBannersService {

    void insertar(Banner banner);
    List<Banner> buscarTodos();
    List<Banner> buscarActivos();
    void eliminar(int idBanner);
    Banner buscarPorId(int idBanner);


}
