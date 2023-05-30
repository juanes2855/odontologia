package co.edu.uniquindio.odontologia.servicios;

import co.edu.uniquindio.odontologia.entidades.*;
import co.edu.uniquindio.odontologia.exceptions.ExcepcionServicios;

import java.util.List;

public interface OdontologoServicio {

    Odontologo login(String correo, String password)  throws ExcepcionServicios;
    Odontologo crearOdontologo(Odontologo odontologo);
    List<Odontologo> listarOdontologos();
    void enviarEnlaceRecuperacion(String correo) throws ExcepcionServicios;


    Agenda crearAgenda(Agenda agenda);
    Agenda actualizarAgenda(Agenda agenda) throws ExcepcionServicios;
    void eliminarAgenda(Integer id)  throws ExcepcionServicios;
    Agenda obtenerAgenda(Integer idAgenda)  throws ExcepcionServicios;
    List<Agenda> listarAgendas();


    HistorialCita crearHistorialCita(HistorialCita historialCita);
    HistorialCita actualizarHistorialCita(HistorialCita historialCita) throws ExcepcionServicios;
    void eliminarHistorialCita(Integer id) throws ExcepcionServicios;
    List<HistorialCita> listarHistorialCitas();
    HistorialCita obtenerHistorialCita(Integer id) throws ExcepcionServicios;

    HistorialMedico crearHistorialMedico(HistorialMedico historialMedico);
    HistorialMedico actualizarHistorialMedico(HistorialMedico historialMedico) throws ExcepcionServicios;
    void eliminarHistorialMedico(Integer codigo) throws ExcepcionServicios;
    List<HistorialMedico> listarHistorialMedicos();
    HistorialMedico obtenerHistorialMedico(Integer codigo) throws ExcepcionServicios;


    Concentimiento crearConcentimiento(Concentimiento concentimiento);
    Concentimiento actualizarConcentimiento(Concentimiento concentimiento) throws ExcepcionServicios;
    void eliminarConcentimiento(Integer codigo) throws ExcepcionServicios;
    List<Concentimiento> listarConcentimientos();
    Concentimiento obtenerConcentimiento(Integer codigo) throws ExcepcionServicios;


    HistorialTratamiento crearHistorialTratamiento(HistorialTratamiento historialTratamiento);
    HistorialTratamiento actualizarHistorialTratamiento(HistorialTratamiento historialTratamiento) throws ExcepcionServicios;
    void eliminarHistorialTratamiento(Integer codigo) throws ExcepcionServicios;
    List<HistorialTratamiento> listarHistorialTratamientos();
    HistorialTratamiento obtenerHistorialTratamiento(Integer codigo) throws ExcepcionServicios;

    
    InfoBasica crearInfoBasica(InfoBasica infoBasica);
    InfoBasica actualizarInfoBasica(InfoBasica infoBasica) throws ExcepcionServicios;
    void eliminarInfoBasica(Integer codigo) throws ExcepcionServicios;
    List<InfoBasica> listarInfoBasicas();
    InfoBasica obtenerInfoBasica(Integer codigo) throws ExcepcionServicios;


    Instrumental crearInstrumental(Instrumental instrumental);
    Instrumental actualizarInstrumental(Instrumental instrumental) throws ExcepcionServicios;
    void eliminarInstrumental(Integer codigo) throws ExcepcionServicios;
    List<Instrumental> listarInstrumentales();
    Instrumental obtenerInstrumental(Integer codigo) throws ExcepcionServicios;


    Odontograma crearOdontograma(Odontograma odontograma);
    Odontograma actualizarOdontograma(Odontograma odontograma) throws ExcepcionServicios;
    void eliminarOdontograma(Integer codigo) throws ExcepcionServicios;
    List<Odontograma> listarOdontogramas();
    Odontograma obtenerOdontograma(Integer codigo) throws ExcepcionServicios;


    Paciente crearPaciente(Paciente paciente);
    Paciente actualizarPaciente(Paciente paciente) throws ExcepcionServicios;
    void eliminarPaciente(Integer codigo) throws ExcepcionServicios;
    List<Paciente> listarPacientes();
    Paciente obtenerPaciente(Integer codigo) throws ExcepcionServicios;


    Tratamiento crearTratamiento(Tratamiento tratamiento);
    Tratamiento actualizarTratamiento(Tratamiento tratamiento) throws ExcepcionServicios;
    void eliminarTratamiento(Integer codigo) throws ExcepcionServicios;
    List<Tratamiento> listarTratamientos();
    Tratamiento obtenerTratamiento(Integer codigo) throws ExcepcionServicios;
    Odontologo obtenerOdontologo(int id) throws ExcepcionServicios;

    boolean cambiarPassword(String param1, String param2, String password) throws Exception;;
}
