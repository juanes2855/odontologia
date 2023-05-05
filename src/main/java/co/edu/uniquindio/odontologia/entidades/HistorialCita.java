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
    @ManyToOne
    private Tratamiento tratamiento;
    @ManyToOne
    private Paciente paciente;

    @Builder
    public HistorialCita(String asistencia, String descripcion, Agenda agenda, Tratamiento tratamiento, Paciente paciente) {
        this.asistencia = asistencia;
        this.descripcion = descripcion;
        this.agenda = agenda;
        this.tratamiento = tratamiento;
        this.paciente = paciente;
    }
}
