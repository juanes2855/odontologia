package co.edu.uniquindio.odontologia.repo;

import co.edu.uniquindio.odontologia.entidades.Odontograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontogramaRepo extends JpaRepository<Odontograma, Integer> {
}
