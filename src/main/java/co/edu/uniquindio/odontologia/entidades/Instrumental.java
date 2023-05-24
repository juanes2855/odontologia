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
public class Instrumental implements Serializable {
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

    @Builder
    public Instrumental(String nombre, String marca, String registro, Integer cantidad) {
        this.nombre = nombre;
        this.marca = marca;
        this.registro = registro;
        this.cantidad = cantidad;
    }
}
