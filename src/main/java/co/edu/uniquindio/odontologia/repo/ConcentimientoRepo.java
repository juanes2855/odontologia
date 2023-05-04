package co.edu.uniquindio.odontologia.repo;

import co.edu.uniquindio.odontologia.entidades.Concentimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcentimientoRepo extends JpaRepository<Concentimiento, Integer> {
}
