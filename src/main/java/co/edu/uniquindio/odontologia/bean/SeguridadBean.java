package co.edu.uniquindio.odontologia.bean;

import co.edu.uniquindio.odontologia.entidades.Odontologo;
import co.edu.uniquindio.odontologia.entidades.Paciente;
import co.edu.uniquindio.odontologia.servicios.OdontologoServicio;
import lombok.Generated;
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

@Generated
@Component
@Scope("session")
public class SeguridadBean implements Serializable {

    private static final String LOGIN_BEAN = "login-bean";
    private static final String ALERTA = "Alerta";

    @Autowired
    private transient OdontologoServicio odontologoServicio;

    @Getter @Setter
    private boolean autenticado;
    @Setter @Getter
    private String email;

    @Setter @Getter
    private String password;
    @Getter @Setter
    private Odontologo odontologo;
    @Getter @Setter
    private List<Paciente> pacientes;

    @Getter @Setter
    private String tipoSesion;


    @PostConstruct
    public void inicializar(){
        autenticado = false;

    }


    public String iniciarSesionOdontologo(){

        if(!email.isEmpty() && !password.isEmpty()){
            try {
                odontologo = odontologoServicio.login( email, password );
                tipoSesion = "odontologo";
                autenticado = true;
                return "/index?faces-redirect=true";

            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, ALERTA, e.getMessage());
                FacesContext.getCurrentInstance().addMessage(LOGIN_BEAN, fm);
            }
        }else{
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, ALERTA, "El correo y la contraseña son necesarios");
            FacesContext.getCurrentInstance().addMessage(LOGIN_BEAN, fm);
        }

        return null;
    }

    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }

    public void recuperarPassword(){
        try {
            if(!email.isEmpty()){
                odontologoServicio.enviarEnlaceRecuperacion( email );
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Se ha enviado el correo de recuperación de la contraseña");
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }else{
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "Debe escribir el correo");
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("login-bean", fm);
        }
    }


}
