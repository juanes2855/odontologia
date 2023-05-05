package co.edu.uniquindio.odontologia.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Odontograma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private Integer numDiente;

    private String descripcion;

    @ManyToOne
    private Paciente paciente;

    @Builder
    public Odontograma(Integer numDiente, String descripcion, Paciente paciente) {
        this.numDiente = numDiente;
        this.descripcion = descripcion;
        this.paciente = paciente;
    }
}
