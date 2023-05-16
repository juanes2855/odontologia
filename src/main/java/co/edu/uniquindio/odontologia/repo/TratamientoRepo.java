package co.edu.uniquindio.odontologia.repo;

import co.edu.uniquindio.odontologia.entidades.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamientoRepo extends JpaRepository<Tratamiento, Integer> {
}
