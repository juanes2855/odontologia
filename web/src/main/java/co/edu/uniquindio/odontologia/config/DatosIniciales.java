package co.edu.uniquindio.odontologia.config;

import co.edu.uniquindio.odontologia.entidades.Odontologo;
import co.edu.uniquindio.odontologia.entidades.Paciente;
import co.edu.uniquindio.odontologia.servicios.OdontologoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DatosIniciales implements CommandLineRunner {
    @Autowired
    private OdontologoServicio odontologoServicio;

    @Override
    public void run(String... args) throws Exception {
        odontologoServicio.crearPaciente(Paciente.builder().documento(1004978129).nombre("Juan Rodrigo").telefono("321654")
                .genero("H").fechaNacimiento(LocalDate.of(1990,10,12)).correo("juanrodri3@gmail.com").build());

        odontologoServicio.crearOdontologo(Odontologo.builder().nombre("Juan Pablo").telefono("1").direccion("1").correo("juanpablo@gf.com").password("1234").build());

    }
}
