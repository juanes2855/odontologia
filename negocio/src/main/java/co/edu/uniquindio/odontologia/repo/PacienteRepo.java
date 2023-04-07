package co.edu.uniquindio.odontologia.repo;


import co.edu.uniquindio.odontologia.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente, Integer> {
}
