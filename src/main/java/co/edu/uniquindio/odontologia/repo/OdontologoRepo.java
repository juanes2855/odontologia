package co.edu.uniquindio.odontologia.repo;

import co.edu.uniquindio.odontologia.entidades.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OdontologoRepo extends JpaRepository<Odontologo, Integer> {

    Optional<Odontologo> findByCorreo(String correo);
}
