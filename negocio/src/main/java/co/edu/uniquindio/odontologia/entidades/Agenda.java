package co.edu.uniquindio.odontologia.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Agenda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;


    @Column(nullable = false)
    private LocalTime hora;

    @Column(nullable = false)
    private LocalDate fecha;
    @Column(length = 45)
    private String estado;


    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Odontologo odontologo;

    @ToString.Exclude
    @OneToOne(mappedBy = "agenda")
    private HistorialCita historialCita;

    @Builder
    public Agenda(LocalTime hora, LocalDate fecha, String estado, Odontologo odontologo, Paciente paciente) {
        this.hora = hora;
        this.fecha = fecha;
        this.estado = estado;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }
}
