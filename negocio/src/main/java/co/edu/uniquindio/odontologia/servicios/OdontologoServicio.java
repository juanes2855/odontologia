package co.edu.uniquindio.odontologia.servicios;

import co.edu.uniquindio.odontologia.entidades.Odontologo;

public interface OdontologoServicio {

    Odontologo login(String correo, String password) throws Exception;


}
