package co.edu.uniquindio.odontologia.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HistorialMedico implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @OneToOne
    @JoinColumn(name = "doc_paciente")
    private Paciente paciente;

    private LocalDate fechaInicial;

    private LocalTime horaInicial;
    @OneToOne
    private InfoBasica infoBasica;

    @OneToOne
    private Concentimiento concentimiento;

    @Builder
    public HistorialMedico(Paciente paciente, Concentimiento concentimiento, InfoBasica infoBasica) {
        this.paciente = paciente;
        this.fechaInicial = LocalDate.now();
        this.horaInicial = LocalTime.now();
        this.concentimiento = concentimiento;
        this.infoBasica = infoBasica;
    }
}
