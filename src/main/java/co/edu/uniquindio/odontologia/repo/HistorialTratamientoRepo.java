package co.edu.uniquindio.odontologia.repo;

import co.edu.uniquindio.odontologia.entidades.HistorialTratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialTratamientoRepo extends JpaRepository<HistorialTratamiento, Integer> {
}
