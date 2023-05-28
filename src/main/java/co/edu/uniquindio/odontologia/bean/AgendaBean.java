package co.edu.uniquindio.odontologia.bean;

import co.edu.uniquindio.odontologia.entidades.Agenda;
import co.edu.uniquindio.odontologia.entidades.Odontologo;
import co.edu.uniquindio.odontologia.entidades.Paciente;
import co.edu.uniquindio.odontologia.servicios.OdontologoServicio;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Generated
@Component
@ViewScoped
public class AgendaBean implements Serializable {

    private static final String MENSAJE_BEAN = "mensaje_bean";
    private static final String ALERTA = "Alerta";

    @Autowired
    private transient OdontologoServicio odontologoServicio;

    @Getter
    @Setter
    private Agenda agenda;

    @Getter
    @Setter
    private List<Agenda> agendas;

    @Getter
    @Setter
    private List<Agenda> agendasSeleccionadas;

    @Getter @Setter
    private List<Odontologo> odontologos;

    @Getter @Setter
    private List<Paciente> pacientes;

    private Boolean editar;


    @PostConstruct
    public void init(){
        agenda = new Agenda();
        editar=false;
        odontologos = odontologoServicio.listarOdontologos();
        pacientes = odontologoServicio.listarPacientes();
        agendasSeleccionadas = new ArrayList<>();
        agendas = odontologoServicio.listarAgendas();
    }

    public void crearAgenda(){
        try {
            if (Boolean.FALSE.equals(editar)) {
                Odontologo odontologo = odontologoServicio.obtenerOdontologo(1);
                agenda.setOdontologo(odontologo);
                Agenda registro = odontologoServicio.crearAgenda(agenda);
                agendas.add(registro);
                agenda = new Agenda();
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, ALERTA, "Agenda creado correctamente");
                FacesContext.getCurrentInstance().addMessage(MENSAJE_BEAN, fm);
            }else{
                odontologoServicio.actualizarAgenda(agenda);
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, ALERTA, "Agenda actualizado correctamente");
                FacesContext.getCurrentInstance().addMessage(MENSAJE_BEAN, fm);
            }
        }catch (Exception e){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, ALERTA, e.getMessage());
            FacesContext.getCurrentInstance().addMessage(MENSAJE_BEAN,fm);
        }

    }

    public void eliminarAgenda(){

        try {
            for (Agenda t: agendasSeleccionadas) {
                odontologoServicio.eliminarAgenda(t.getId());
                agendas.remove(t);
            }
            agendasSeleccionadas.clear();
        }catch (Exception e){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, ALERTA, e.getMessage());
            FacesContext.getCurrentInstance().addMessage(MENSAJE_BEAN,fm);
        }

    }


    public String getTextoBtnBorrar(){
        if (agendasSeleccionadas.isEmpty()){
            return "Borrar";
        }else{
            return agendasSeleccionadas.size()==1?  "Borrar 1 elemento" : "Borrar "+agendasSeleccionadas.size()+ " Elementos";
        }
    }

    public String getMensajeCrear() {
        if (editar) {
            return "Editar Agenda";
        } else {
            return "Crear Agenda";
        }
    }

    public void seleccionarAgenda(Agenda agendaSeleccionado){
        this.agenda=agendaSeleccionado;
        editar=true;
    }
    public void crearAgendaDialogo(){
        this.agenda= new Agenda();
        editar=false;
    }

}
