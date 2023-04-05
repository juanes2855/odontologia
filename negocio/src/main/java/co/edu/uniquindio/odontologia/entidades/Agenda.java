package co.edu.uniquindio.odontologia.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;

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

    @Positive
    @Column(nullable = false)
    private String hora;

    @Column(nullable = false)
    private LocalDate fecha;
    @Column(length = 45)
    private String estado;


    @OneToOne
    private Odontologo odontologo;

    @OneToOne(mappedBy = "agenda")
    private HistorialCita historialCita;

}
