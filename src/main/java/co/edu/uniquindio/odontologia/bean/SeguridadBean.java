package co.edu.uniquindio.odontologia.bean;

import co.edu.uniquindio.odontologia.entidades.Odontologo;
import co.edu.uniquindio.odontologia.entidades.Paciente;
import co.edu.uniquindio.odontologia.servicios.OdontologoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@Component
@Scope("session")
public class SeguridadBean implements Serializable {

    @Autowired
    private transient OdontologoServicio odontologoServicio;

    @Getter @Setter
    private boolean autenticado;
    @Setter @Getter
    private String email, password;
    @Getter @Setter
    private Odontologo odontologo;
    @Getter @Setter
    private List<Paciente> pacientes;

    @Getter @Setter
    private String tipoSesion;


    @PostConstruct
    public void inicializar(){
        autenticado = false;
        System.out.println("hola careehimb");
    }


    public String iniciarSesionOdontologo(){

        if(!email.isEmpty() && !password.isEmpty()){
            try {
                odontologo = odontologoServicio.login( email, password );
                tipoSesion = "odontologo";
                autenticado = true;
                return "/index?faces-redirect=true";

            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        }else{
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "El correo y la contraseña son necesarios");
            FacesContext.getCurrentInstance().addMessage("login-bean", fm);
        }

        return null;
    }

    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }


}
