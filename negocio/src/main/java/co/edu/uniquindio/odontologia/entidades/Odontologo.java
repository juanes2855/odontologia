package co.edu.uniquindio.odontologia.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Odontologo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Length(max = 150)
    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(length = 45)
    private String telefono;

    @Column(length = 150)
    private String direccion;

    @NotNull
    @Email
    @Length(max = 200)
    @Column(nullable = false, unique = true, length = 200)
    private String correo;

    @ToString.Exclude
    @Length(max = 150)
    @Column(nullable = false, length = 150)
    private String password;


    @OneToOne(mappedBy = "odontologo")
    private Agenda agenda;


}
