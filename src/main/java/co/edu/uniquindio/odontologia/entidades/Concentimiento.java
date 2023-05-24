package co.edu.uniquindio.odontologia.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Generated
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Concentimiento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;


    @Column(nullable = false,length = 100)
    private String nombre;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String procedimiento;

    @Column(nullable = false)
    private String riesgos;
    @ToString.Exclude
    @OneToOne(mappedBy = "concentimiento")
    private HistorialMedico historialMedico;

    @Builder
    public Concentimiento(String nombre, String procedimiento, String riesgos) {
        this.nombre = nombre;
        this.fecha = LocalDate.now();
        this.procedimiento = procedimiento;
        this.riesgos = riesgos;
    }
}
