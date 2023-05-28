package co.edu.uniquindio.odontologia.bean;

import co.edu.uniquindio.odontologia.entidades.Odontologo;
import co.edu.uniquindio.odontologia.entidades.Paciente;
import co.edu.uniquindio.odontologia.servicios.OdontologoServicio;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
@Generated
@Component
@ViewScoped
public class OdontologoBean implements Serializable {

    private static final String MENSAJE_BEAN = "mensaje_bean";
    private static final String ALERTA = "Alerta";

    @Autowired
    private transient OdontologoServicio odontologoServicio;

    @Getter
    @Setter
    private Odontologo odontologo;
    @PostConstruct
    public void init(){
        odontologo = new Odontologo();
    }
}
