package co.edu.uniquindio.odontologia.repo;


import co.edu.uniquindio.odontologia.entidades.Instrumental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentalRepo extends JpaRepository<Instrumental, Integer> {
}
