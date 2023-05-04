package co.edu.uniquindio.odontologia.repo;

import co.edu.uniquindio.odontologia.entidades.HistorialMedico;
import co.edu.uniquindio.odontologia.entidades.Odontologo;
import co.edu.uniquindio.odontologia.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Repository
public interface HistorialMedicoRepo extends JpaRepository<HistorialMedico, Integer> {

    @Query("select HM from HistorialMedico HM where HM.paciente.documento = :documento")
    Optional<HistorialMedico> obtenerHistorialMedicoXpaciente(Integer documento);
}
