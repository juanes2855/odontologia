package co.edu.uniquindio.odontologia.repo;

import co.edu.uniquindio.odontologia.entidades.HistorialMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialMedicoRepo extends JpaRepository<HistorialMedico, Integer> {
}
