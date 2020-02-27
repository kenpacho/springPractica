package net.carlosPracticas.app.repository;

import net.carlosPracticas.app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {


}
