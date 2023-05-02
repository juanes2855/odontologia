package co.edu.uniquindio.odontologia.servicios;

import co.edu.uniquindio.odontologia.entidades.*;

import java.util.List;

public interface OdontologoServicio {

    Odontologo login(String correo, String password) throws Exception;
    Odontologo crearOdontologo(Odontologo odontologo);

    Agenda crearAgenda(Agenda agenda);
    Agenda actualizarAgenda(Agenda agenda) throws Exception;
    void eliminarAgenda(Integer id) throws  Exception;
    Agenda obtenerAgenda(Integer idAgenda) throws Exception;
    List<Agenda> listarAgendas();


    HistorialCita crearHistorialCita(HistorialCita historialCita);
    HistorialCita actualizarHistorialCita(HistorialCita historialCita) throws Exception;
    void eliminarHistorialCita(Integer id) throws Exception;
    List<HistorialCita> listarHistorialCitas();
    HistorialCita obtenerHistorialCita(Integer id) throws Exception;

    HistorialMedico crearHistorialMedico(HistorialMedico historialMedico);
    HistorialMedico actualizarHistorialMedico(HistorialMedico historialMedico) throws Exception;
    void eliminarHistorialMedico(Integer codigo) throws Exception;
    List<HistorialMedico> listarHistorialMedicos();
    HistorialMedico obtenerHistorialMedico(Integer codigo) throws Exception;


    Concentimiento crearConcentimiento(Concentimiento concentimiento);
    Concentimiento actualizarConcentimiento(Concentimiento concentimiento) throws Exception;
    void eliminarConcentimiento(Integer codigo) throws Exception;
    List<Concentimiento> listarConcentimientos();
    Concentimiento obtenerConcentimiento(Integer codigo) throws Exception;


    HistorialTratamiento crearHistorialTratamiento(HistorialTratamiento historialTratamiento);
    HistorialTratamiento actualizarHistorialTratamiento(HistorialTratamiento historialTratamiento) throws Exception;
    void eliminarHistorialTratamiento(Integer codigo) throws Exception;
    List<HistorialTratamiento> listarHistorialTratamientos();
    HistorialTratamiento obtenerHistorialTratamiento(Integer codigo) throws Exception;

    
    InfoBasica crearInfoBasica(InfoBasica infoBasica);
    InfoBasica actualizarInfoBasica(InfoBasica infoBasica) throws Exception;
    void eliminarInfoBasica(Integer codigo) throws Exception;
    List<InfoBasica> listarInfoBasicas();
    InfoBasica obtenerInfoBasica(Integer codigo) throws Exception;


    Instrumental crearInstrumental(Instrumental instrumental);
    Instrumental actualizarInstrumental(Instrumental instrumental) throws Exception;
    void eliminarInstrumental(Integer codigo) throws Exception;
    List<Instrumental> listarInstrumentales();
    Instrumental obtenerInstrumental(Integer codigo) throws Exception;


    Odontograma crearOdontograma(Odontograma odontograma);
    Odontograma actualizarOdontograma(Odontograma odontograma) throws Exception;
    void eliminarOdontograma(Integer codigo) throws Exception;
    List<Odontograma> listarOdontogramas();
    Odontograma obtenerOdontograma(Integer codigo) throws Exception;


    Paciente crearPaciente(Paciente paciente);
    Paciente actualizarPaciente(Paciente paciente) throws Exception;
    void eliminarPaciente(Integer codigo) throws Exception;
    List<Paciente> listarPacientes();
    Paciente obtenerPaciente(Integer codigo) throws Exception;


    Tratamiento crearTratamiento(Tratamiento tratamiento);
    Tratamiento actualizarTratamiento(Tratamiento tratamiento) throws Exception;
    void eliminarTratamiento(Integer codigo) throws Exception;
    List<Tratamiento> listarTratamientos();
    Tratamiento obtenerTratamiento(Integer codigo) throws Exception;
    Odontologo obtenerOdontologo(int id) throws Exception;
}
