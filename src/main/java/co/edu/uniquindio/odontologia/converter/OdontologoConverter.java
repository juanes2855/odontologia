package co.edu.uniquindio.odontologia.converter;

import co.edu.uniquindio.odontologia.entidades.Odontologo;
import co.edu.uniquindio.odontologia.servicios.OdontologoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class OdontologoConverter implements Converter<Odontologo>, Serializable {

    @Autowired
    private transient OdontologoServicio odontologoServicio;

    @Override
    public Odontologo getAsObject(FacesContext context, UIComponent component, String value) {
        Odontologo odontologo = null;
        try {
            odontologo = odontologoServicio.obtenerOdontologo(Integer.parseInt(value));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return odontologo;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Odontologo value) {
        if(value != null){
            return value.getId()+"";
        }
        return "";
    }

}
