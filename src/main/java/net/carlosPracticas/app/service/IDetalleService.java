package net.carlosPracticas.app.service;

import net.carlosPracticas.app.model.Detalle;

public interface IDetalleService {
    void insertar(Detalle detalle);
    void eliminar(int idDetalle);
}
