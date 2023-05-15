package co.edu.uniquindio.odontologia.bean;

import co.edu.uniquindio.odontologia.entidades.Agenda;
import co.edu.uniquindio.odontologia.entidades.Odontologo;
import co.edu.uniquindio.odontologia.entidades.Paciente;
import co.edu.uniquindio.odontologia.servicios.OdontologoServicio;
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

@Component
@ViewScoped
public class AgendaBean implements Serializable {

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
            if (!editar) {
                Odontologo odontologo = odontologoServicio.obtenerOdontologo(1);
                agenda.setOdontologo(odontologo);
                Agenda registro = odontologoServicio.crearAgenda(agenda);
                agendas.add(registro);
                agenda = new Agenda();
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Agenda creado correctamente");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }else{
                odontologoServicio.actualizarAgenda(agenda);
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Agenda actualizado correctamente");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        }catch (Exception e){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean",fm);
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
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean",fm);;
        }

    }


    public String getTextoBtnBorrar(){
        if (agendasSeleccionadas.isEmpty()){
            return "Borrar";
        }else{
            return agendasSeleccionadas.size()==1?  "Borrar 1 elemento" : "Borrar "+agendasSeleccionadas.size()+ " Elementos";
        }
    }

    public String getMensajeCrear(){
        return editar ? "Editar Agenda" : "Crear Agenda";
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
