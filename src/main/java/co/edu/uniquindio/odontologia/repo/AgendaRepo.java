package co.edu.uniquindio.odontologia.repo;

import co.edu.uniquindio.odontologia.entidades.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaRepo extends JpaRepository<Agenda, Integer> {

}
