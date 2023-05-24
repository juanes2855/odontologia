package co.edu.uniquindio.odontologia.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
@Generated
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
    @OneToOne(mappedBy = "paciente")
    private HistorialTratamiento historialTratamiento;
    @ToString.Exclude
    @OneToMany(mappedBy = "paciente")
    private List<Odontograma> odontogramas;
    @ToString.Exclude
    @OneToMany(mappedBy = "paciente")
    private List<HistorialCita> historialCitas;

    @ToString.Exclude
    @OneToMany(mappedBy = "paciente")
    private List<Agenda> agendas;


    @ToString.Exclude
    @OneToOne(mappedBy = "paciente")
    private HistorialMedico historialMedico;

    @Builder
    public Paciente(Integer documento, String nombre, String telefono, String direccion, String genero, LocalDate fechaNacimiento, String correo) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = LocalDate.now();
        this.correo = correo;
    }

    public int getEdad(){
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
}
