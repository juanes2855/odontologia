package co.edu.uniquindio.odontologia.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

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

    @OneToOne(mappedBy = "concentimiento")
    private HistorialMedico historialMedico;

    @Builder
    public Concentimiento(String nombre, LocalDate fecha, String procedimiento, String riesgos) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.procedimiento = procedimiento;
        this.riesgos = riesgos;
    }
}
