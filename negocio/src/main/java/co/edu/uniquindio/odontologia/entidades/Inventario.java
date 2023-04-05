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
public class Inventario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column( length = 100)
    private String nombre;

    @Column(length = 100)
    private String marca;

    @Column(length = 100)
    private String registro;

    private Integer cantidad;

}
