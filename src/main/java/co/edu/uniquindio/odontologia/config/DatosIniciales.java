package co.edu.uniquindio.odontologia.config;

import co.edu.uniquindio.odontologia.servicios.OdontologoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales implements CommandLineRunner {
    @Autowired
    private OdontologoServicio odontologoServicio;

    @Override
    public void run(String... args) throws Exception {

    }
}