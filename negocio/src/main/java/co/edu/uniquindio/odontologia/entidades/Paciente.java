package co.edu.uniquindio.odontologia.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Paciente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer documento;


    @Column(nullable = false)
    private String nombre;

    @Column(length = 45)
    private String telefono;

    @Column(length = 150)
    private String direccion;
    @Column(length = 1)
    private String genero;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private LocalDate fechaRegistro;

    @NotNull
    @Email
    @Length(max = 200)
    @Column(nullable = false, unique = true, length = 200)
    private String correo;

    @ToString.Exclude
    @Length(max = 150)
    @Column(nullable = false, length = 150)
    private String password;

    @OneToOne(mappedBy = "paciente")
    private HistorialTratamiento historialTratamiento;

    @OneToMany(mappedBy = "paciente")
    private List<Odontograma> odontogramas;

    @OneToMany(mappedBy = "paciente")
    private List<HistorialCita> historialCitas;

    @OneToOne(mappedBy = "paciente")
    private HistorialMedico historialMedico;

    @Builder
    public Paciente(Integer documento, String nombre, String telefono, String direccion, String genero, LocalDate fechaNacimiento, String correo, String password) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = LocalDate.now();
        this.correo = correo;
        this.password = password;
    }
}
