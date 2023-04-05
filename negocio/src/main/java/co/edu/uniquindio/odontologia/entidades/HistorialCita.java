package co.edu.uniquindio.odontologia.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HistorialCita implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column( length = 100)
    private String asistencia;

    private String descripcion;

    @OneToOne
    private Agenda agenda;
    @OneToOne
    private Tratamiento tratamiento;
    @ManyToOne
    private Paciente paciente;

}
