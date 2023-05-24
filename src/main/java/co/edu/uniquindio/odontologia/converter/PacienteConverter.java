package co.edu.uniquindio.odontologia.converter;

import co.edu.uniquindio.odontologia.entidades.Paciente;
import co.edu.uniquindio.odontologia.exceptions.ExcepcionEjecucion;
import co.edu.uniquindio.odontologia.servicios.OdontologoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class PacienteConverter implements Converter<Paciente>, Serializable {

    @Autowired
    private transient OdontologoServicio odontologoServicio;

    @Override
    public Paciente getAsObject(FacesContext context, UIComponent component, String value) {
        Paciente paciente = null;
        try {
            paciente = odontologoServicio.obtenerPaciente(Integer.parseInt(value));
        } catch (Exception e) {
            throw new ExcepcionEjecucion(e);
        }
        return paciente;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Paciente value) {
        if (value != null) {
            return value.getDocumento() + "";
        }
        return "";
    }

}
