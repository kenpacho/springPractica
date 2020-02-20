package net.carlosPracticas.app.service;

import net.carlosPracticas.app.model.Detalle;
import net.carlosPracticas.app.repository.DetallesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallesServiceJPA  implements IDetalleService{

    @Autowired
    private DetallesRepository detalleRepo;

    @Override
    public void insertar(Detalle detalle) {
        detalleRepo.save(detalle);
    }

    @Override
    public void eliminar(int idDetalle) {
        detalleRepo.deleteById(idDetalle);
    }
}
