package co.edu.uniquindio.odontologia.repo;

import co.edu.uniquindio.odontologia.entidades.HistorialCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialCitaRepo extends JpaRepository<HistorialCita, Integer> {
}
