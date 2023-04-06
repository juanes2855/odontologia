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
public class Tratamiento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 200)
    private String nombre;

    private String descripcion;

    @OneToOne(mappedBy = "tratamiento")
    private HistorialCita historialCita;

    @OneToOne(mappedBy = "tratamiento")
    private HistorialTratamiento historialTratamiento;
    @Builder
    public Tratamiento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
