package co.edu.uniquindio.odontologia.bean;

import co.edu.uniquindio.odontologia.servicios.OdontologoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class GestionCuentaBean implements Serializable {

    @Autowired
    private OdontologoServicio odontologoServicio;

    @Value("#{param['p1']}")
    private String param1;

    @Value("#{param['p2']}")
    private String param2;

    @Getter @Setter
    private String mensaje = "Verificando su cuenta ...";

    @Getter @Setter
    private String password, confirmacionPassword;


    public void cambiarPassword(){
        if(param1 != null && !param1.isEmpty() && param2 != null && !param2.isEmpty() ) {
            FacesMessage fm;
            try {
                if(password.equals(confirmacionPassword)) {
                    odontologoServicio.cambiarPassword(param1, param2, password);
                    fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Se ha cambiado su contraseña!");
                    FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
                }
            } catch (Exception e) {
                fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        }
    }


}
