package co.edu.uniquindio.odontologia.repo;

import co.edu.uniquindio.odontologia.entidades.HistorialMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistorialMedicoRepo extends JpaRepository<HistorialMedico, Integer> {

    @Query("select HM from HistorialMedico HM where HM.paciente.documento = :documento")
    Optional<HistorialMedico> obtenerHistorialMedicoXpaciente(Integer documento);
}
