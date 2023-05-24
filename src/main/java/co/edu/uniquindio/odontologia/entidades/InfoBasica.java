package co.edu.uniquindio.odontologia.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Generated
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InfoBasica implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 100)
    private String nombreAcompanante;

    @Column(length = 45)
    private String telefonoAcompante;

    @Lob
    private String motivo;

    @Lob
    private String antecedentesMedicosPersonales;

    @Lob
    private String estomatologico;
    @ToString.Exclude
    @OneToOne(mappedBy = "infoBasica")
    private HistorialMedico historialMedico;

    @Builder
    public InfoBasica(String nombreAcompanante, String telefonoAcompante, String motivo, String antecedentesMedicosPersonales, String estomatologico) {
        this.nombreAcompanante = nombreAcompanante;
        this.telefonoAcompante = telefonoAcompante;
        this.motivo = motivo;
        this.antecedentesMedicosPersonales = antecedentesMedicosPersonales;
        this.estomatologico = estomatologico;
    }
}
