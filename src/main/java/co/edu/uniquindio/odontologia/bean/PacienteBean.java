package co.edu.uniquindio.odontologia.bean;

import co.edu.uniquindio.odontologia.entidades.Agenda;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Generated
@Component
@ViewScoped
public class PacienteBean implements Serializable {

    private static final String MENSAJE_BEAN = "mensaje_bean";
    private static final String ALERTA = "Alerta";
    @Autowired
    private transient OdontologoServicio odontologoServicio;
    @Getter
    @Setter
    private Paciente paciente;

    @Getter
    @Setter
    private List<Paciente> pacientes;


    @Getter
    @Setter
    private List<Paciente> pacientesSeleccionados;

    private Boolean editar;
    @Getter
    @Setter
    private int edad;



    @PostConstruct
    public void init(){
        paciente = new Paciente();
        editar = false;
        pacientes = odontologoServicio.listarPacientes();
        pacientesSeleccionados = new ArrayList<>();

    }

    public void crearPaciente (){
        try{
            if (Boolean.FALSE.equals(editar)) {
                paciente.setFechaRegistro(LocalDate.now());
                Paciente registro = odontologoServicio.crearPaciente(paciente);
                pacientes.add(registro);
                paciente = new Paciente();
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, ALERTA, "El paciente "+registro.getNombre() + " fue creado correctamente");
                FacesContext.getCurrentInstance().addMessage(MENSAJE_BEAN, fm);
            }else{
                odontologoServicio.actualizarPaciente(paciente);
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, ALERTA, "Paciente actualizado correctamente");
                FacesContext.getCurrentInstance().addMessage(MENSAJE_BEAN, fm);
            }
        }catch (Exception e){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, ALERTA, e.getMessage());
            FacesContext.getCurrentInstance().addMessage(MENSAJE_BEAN,fm);
        }
    }

    public  void eliminarPaciente(){
        try{
            for(Paciente t: pacientesSeleccionados){
                odontologoServicio.eliminarPaciente(t.getDocumento());
                pacientes.remove(t);
            }
            pacientesSeleccionados.clear();
        }catch (Exception e){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, ALERTA, e.getMessage());
            FacesContext.getCurrentInstance().addMessage(MENSAJE_BEAN,fm);
        }
    }

    public String getTextoBtnBorrar(){
        if (pacientesSeleccionados.isEmpty()){
            return "Borrar";
        }else{
            return pacientesSeleccionados.size()==1?  "Borrar 1 elemento" : "Borrar "+pacientesSeleccionados.size()+ " Elementos";
        }
    }

    public String getMensajeCrear() {
        if (Boolean.TRUE.equals(editar)) {
            return "Editar Paciente";
        } else {
            return "Crear paciente";
        }
    }

    public void seleccionarPaciente(Paciente pacienteSeleccionado){
        this.paciente=pacienteSeleccionado;
        editar=true;
    }
    public void crearPacienteDialogo(){
        this.paciente= new Paciente();
        editar=false;
    }

}
