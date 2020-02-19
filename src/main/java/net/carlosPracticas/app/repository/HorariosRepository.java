package net.carlosPracticas.app.repository;
import net.carlosPracticas.app.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {
}
