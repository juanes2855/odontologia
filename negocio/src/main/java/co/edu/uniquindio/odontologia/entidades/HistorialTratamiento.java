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
public class HistorialTratamiento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 45)
    private String estado;

    @OneToOne
    private Paciente paciente;

    @OneToOne
    private Tratamiento tratamiento;

    @Builder
    public HistorialTratamiento(String estado, Paciente paciente, Tratamiento tratamiento) {
        this.estado = estado;
        this.paciente = paciente;
        this.tratamiento = tratamiento;
    }
}
