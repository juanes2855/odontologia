package co.edu.uniquindio.odontologia.servicios;

import co.edu.uniquindio.odontologia.entidades.*;
import co.edu.uniquindio.odontologia.exceptions.ExcepcionServicios;
import co.edu.uniquindio.odontologia.repo.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServicioImpl implements OdontologoServicio {
    private static final String AGENDA_NOEXISTE = "La agenda no existe";
    private static final String HISTORIALMEDICO_NOEXISTE = "El historial medico no existe";
    private static final String CONCENTIMIENTO_NOEXISTE = "El concentimiento no existe";
    private static final String HISTORIALTRATAMIENTO_NOEXISTE = "El historial de Tratamiento no existe";
    private static final String INFOBASICA_NOEXISTE = "La información basica no existe";
    private static final String INSTRUMENTAL_NOEXISTE = "El instrumental no existe";
    private static final String ODONTOGRAMA_NOEXISTE = "El odontograma no existe";
    private static final String PACIENTE_NOEXISTE = "El paciente no existe";
    private static final String TRATAMIENTO_NOEXISTE = "El tratamiento no existe";

    private final AgendaRepo agendaRepo;
    private final ConcentimientoRepo concentimientoRepo;
    private final HistorialCitaRepo historialCitaRepo;
    private final HistorialMedicoRepo historialMedicoRepo;
    private final HistorialTratamientoRepo historialTratamientoRepo;
    private final InfoBasicaRepo infoBasicaRepo;
    private final InstrumentalRepo instrumentalRepo;
    private final OdontogramaRepo odontogramaRepo;
    private final OdontologoRepo odontologoRepo;
    private final PacienteRepo pacienteRepo;
    private final TratamientoRepo tratamientoRepo;

    public OdontologoServicioImpl(AgendaRepo agendaRepo, ConcentimientoRepo concentimientoRepo, HistorialCitaRepo historialCitaRepo, HistorialMedicoRepo historialMedicoRepo, HistorialTratamientoRepo historialTratamientoRepo, InfoBasicaRepo infoBasicaRepo, InstrumentalRepo instrumentalRepo, OdontogramaRepo odontogramaRepo, OdontologoRepo odontologoRepo, PacienteRepo pacienteRepo, TratamientoRepo tratamientoRepo) {
        this.agendaRepo = agendaRepo;
        this.concentimientoRepo = concentimientoRepo;
        this.historialCitaRepo = historialCitaRepo;
        this.historialMedicoRepo = historialMedicoRepo;
        this.historialTratamientoRepo = historialTratamientoRepo;
        this.infoBasicaRepo = infoBasicaRepo;
        this.instrumentalRepo = instrumentalRepo;
        this.odontogramaRepo = odontogramaRepo;
        this.odontologoRepo = odontologoRepo;
        this.pacienteRepo = pacienteRepo;
        this.tratamientoRepo = tratamientoRepo;
    }

    @Override
    public Odontologo login(String correo, String password)  throws ExcepcionServicios {
        Odontologo odontologo = odontologoRepo.findByCorreo(correo).orElse(null);
        if (odontologo != null) {
            if (!password.equals(odontologo.getPassword())) {
                throw new ExcepcionServicios("La contraseña es incorrecta");
            }else {
                return odontologo;
            }
        }
        else {
            throw new ExcepcionServicios("El Odontologo no existe");
        }

    }

    @Override
    public Odontologo crearOdontologo(Odontologo odontologo) {
        return odontologoRepo.save(odontologo);
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        return odontologoRepo.findAll();
    }

    @Override
    public Odontologo obtenerOdontologo(int id) throws  ExcepcionServicios {
        Optional<Odontologo> guardado = odontologoRepo.findById(id);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios("El odontologo no existe");
        }

        return guardado.get();
    }

    @Override
    public Agenda crearAgenda(Agenda agenda) {
        return agendaRepo.save(agenda);
    }

    @Override
    public Agenda actualizarAgenda(Agenda agenda) throws ExcepcionServicios {
        Optional<Agenda> guardado = agendaRepo.findById(agenda.getId());

        if (guardado.isEmpty()) {
            throw new ExcepcionServicios(AGENDA_NOEXISTE);
        }

        return agendaRepo.save(agenda);
    }

    @Override
    public void eliminarAgenda(Integer id)  throws ExcepcionServicios {
        Optional<Agenda> guardado = agendaRepo.findById(id);

        if (guardado.isEmpty()) {
            throw new ExcepcionServicios(AGENDA_NOEXISTE);
        }

        agendaRepo.delete(guardado.get());
    }

    @Override
    public Agenda obtenerAgenda(Integer idAgenda)  throws ExcepcionServicios {
        Optional<Agenda> guardado = agendaRepo.findById(idAgenda);

        if (guardado.isEmpty()) {
            throw new ExcepcionServicios(AGENDA_NOEXISTE);
        }

        return guardado.get();
    }

    @Override
    public List<Agenda> listarAgendas() {
        return agendaRepo.findAll();

    }

    @Override
    public HistorialCita


    crearHistorialCita(HistorialCita historialCita) {
        return historialCitaRepo.save(historialCita);
    }

    @Override
    public HistorialCita actualizarHistorialCita(HistorialCita historialCita) throws  ExcepcionServicios {
        Optional<HistorialCita> guardado = historialCitaRepo.findById(historialCita.getId());

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios("El historial de cita no existe");
        }

        return historialCitaRepo.save(historialCita);
    }

    @Override
    public void eliminarHistorialCita(Integer id) throws ExcepcionServicios{
        Optional<HistorialCita> guardado = historialCitaRepo.findById(id);

        if (guardado.isEmpty()) {
            throw new ExcepcionServicios("El historial Cita no existe");
        }

        historialCitaRepo.delete(guardado.get());
    }

    @Override
    public List<HistorialCita> listarHistorialCitas() {
        return historialCitaRepo.findAll();
    }

    @Override
    public HistorialCita obtenerHistorialCita(Integer id) throws  ExcepcionServicios {
        Optional<HistorialCita> guardado = historialCitaRepo.findById(id);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios("El historial Cita no existe");
        }

        return guardado.get();
    }

    @Override
    public HistorialMedico crearHistorialMedico(HistorialMedico historialMedico) {
        return historialMedicoRepo.save(historialMedico);
    }

    @Override
    public HistorialMedico actualizarHistorialMedico(HistorialMedico historialMedico) throws  ExcepcionServicios {
        Optional<HistorialMedico> guardado = historialMedicoRepo.findById(historialMedico.getId());

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(HISTORIALMEDICO_NOEXISTE);
        }

        return historialMedicoRepo.save(historialMedico);
    }

    @Override
    public void eliminarHistorialMedico(Integer codigo) throws  ExcepcionServicios {
        Optional<HistorialMedico> guardado = historialMedicoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(HISTORIALMEDICO_NOEXISTE);
        }

        historialMedicoRepo.delete(guardado.get());
    }

    @Override
    public List<HistorialMedico> listarHistorialMedicos() {
        return historialMedicoRepo.findAll();
    }

    @Override
    public HistorialMedico obtenerHistorialMedico(Integer codigo) throws  ExcepcionServicios {
        Optional<HistorialMedico> guardado = historialMedicoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(HISTORIALMEDICO_NOEXISTE);
        }

        return guardado.get();
    }

    @Override
    public Concentimiento crearConcentimiento(Concentimiento concentimiento) {
        return concentimientoRepo.save(concentimiento);
    }

    @Override
    public Concentimiento actualizarConcentimiento(Concentimiento concentimiento) throws  ExcepcionServicios {
        Optional<Concentimiento> guardado = concentimientoRepo.findById(concentimiento.getId());

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(CONCENTIMIENTO_NOEXISTE);
        }

        return concentimientoRepo.save(concentimiento);
    }

    @Override
    public void eliminarConcentimiento(Integer codigo) throws  ExcepcionServicios {
        Optional<Concentimiento> guardado = concentimientoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(CONCENTIMIENTO_NOEXISTE);
        }

        concentimientoRepo.delete(guardado.get());
    }

    @Override
    public List<Concentimiento> listarConcentimientos() {
        return concentimientoRepo.findAll();
    }

    @Override
    public Concentimiento obtenerConcentimiento(Integer codigo) throws  ExcepcionServicios {
        Optional<Concentimiento> guardado = concentimientoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(CONCENTIMIENTO_NOEXISTE);
        }

        return guardado.get();
    }

    @Override
    public HistorialTratamiento crearHistorialTratamiento(HistorialTratamiento historialTratamiento) {
        return historialTratamientoRepo.save(historialTratamiento);
    }

    @Override
    public HistorialTratamiento actualizarHistorialTratamiento(HistorialTratamiento historialTratamiento) throws  ExcepcionServicios {
        Optional<HistorialTratamiento> guardado = historialTratamientoRepo.findById(historialTratamiento.getId());

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(HISTORIALTRATAMIENTO_NOEXISTE);
        }

        return historialTratamientoRepo.save(historialTratamiento);
    }

    @Override
    public void eliminarHistorialTratamiento(Integer codigo) throws  ExcepcionServicios {
        Optional<HistorialTratamiento> guardado = historialTratamientoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(HISTORIALTRATAMIENTO_NOEXISTE);
        }

        historialTratamientoRepo.delete(guardado.get());
    }

    @Override
    public List<HistorialTratamiento> listarHistorialTratamientos() {
        return historialTratamientoRepo.findAll();
    }

    @Override
    public HistorialTratamiento obtenerHistorialTratamiento(Integer codigo) throws  ExcepcionServicios {
        Optional<HistorialTratamiento> guardado = historialTratamientoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(HISTORIALTRATAMIENTO_NOEXISTE);
        }

        return guardado.get();
    }

    @Override
    public InfoBasica crearInfoBasica(InfoBasica infoBasica) {
        return infoBasicaRepo.save(infoBasica);
    }

    @Override
    public InfoBasica actualizarInfoBasica(InfoBasica infoBasica) throws  ExcepcionServicios {
        Optional<InfoBasica> guardado = infoBasicaRepo.findById(infoBasica.getId());

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(INFOBASICA_NOEXISTE);
        }

        return infoBasicaRepo.save(infoBasica);
    }

    @Override
    public void eliminarInfoBasica(Integer codigo) throws  ExcepcionServicios {
        Optional<InfoBasica> guardado = infoBasicaRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(INFOBASICA_NOEXISTE);
        }

        infoBasicaRepo.delete(guardado.get());
    }

    @Override
    public List<InfoBasica> listarInfoBasicas() {
        return infoBasicaRepo.findAll();
    }

    @Override
    public InfoBasica obtenerInfoBasica(Integer codigo) throws  ExcepcionServicios {
        Optional<InfoBasica> guardado = infoBasicaRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(INFOBASICA_NOEXISTE);
        }

        return guardado.get();
    }

    @Override
    public Instrumental crearInstrumental(Instrumental instrumental) {
        return instrumentalRepo.save(instrumental);
    }

    @Override
    public Instrumental actualizarInstrumental(Instrumental instrumental) throws  ExcepcionServicios {
        Optional<Instrumental> guardado = instrumentalRepo.findById(instrumental.getId());

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(INSTRUMENTAL_NOEXISTE);
        }

        return instrumentalRepo.save(instrumental);
    }

    @Override
    public void eliminarInstrumental(Integer codigo) throws  ExcepcionServicios {
        Optional<Instrumental> guardado = instrumentalRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(INSTRUMENTAL_NOEXISTE);
        }

        instrumentalRepo.delete(guardado.get());
    }

    @Override
    public List<Instrumental> listarInstrumentales() {
        return instrumentalRepo.findAll();
    }

    @Override
    public Instrumental obtenerInstrumental(Integer codigo) throws  ExcepcionServicios {
        Optional<Instrumental> guardado = instrumentalRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(INSTRUMENTAL_NOEXISTE);
        }

        return guardado.get();
    }

    @Override
    public Odontograma crearOdontograma(Odontograma odontograma) {
        return odontogramaRepo.save(odontograma);
    }

    @Override
    public Odontograma actualizarOdontograma(Odontograma odontograma) throws  ExcepcionServicios {
        Optional<Odontograma> guardado = odontogramaRepo.findById(odontograma.getId());

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(ODONTOGRAMA_NOEXISTE);
        }

        return odontogramaRepo.save(odontograma);
    }

    @Override
    public void eliminarOdontograma(Integer codigo) throws  ExcepcionServicios {
        Optional<Odontograma> guardado = odontogramaRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(ODONTOGRAMA_NOEXISTE);
        }

        odontogramaRepo.delete(guardado.get());
    }

    @Override
    public List<Odontograma> listarOdontogramas() {
        return odontogramaRepo.findAll();
    }

    @Override
    public Odontograma obtenerOdontograma(Integer codigo) throws  ExcepcionServicios {
        Optional<Odontograma> guardado = odontogramaRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(ODONTOGRAMA_NOEXISTE);
        }

        return guardado.get();
    }

    @Override
    public Paciente crearPaciente(Paciente paciente) {
        return pacienteRepo.save(paciente);
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) throws  ExcepcionServicios {
        Optional<Paciente> guardado = pacienteRepo.findById(paciente.getDocumento());

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(PACIENTE_NOEXISTE);
        }

        return pacienteRepo.save(paciente);
    }

    @Override
    public void eliminarPaciente(Integer codigo) throws  ExcepcionServicios {
        Optional<Paciente> guardado = pacienteRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(PACIENTE_NOEXISTE);
        }

        pacienteRepo.delete(guardado.get());
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepo.findAll();
    }

    @Override
    public Paciente obtenerPaciente(Integer codigo) throws  ExcepcionServicios {
        Optional<Paciente> guardado = pacienteRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(PACIENTE_NOEXISTE);
        }

        return guardado.get();
    }

    @Override
    public Tratamiento crearTratamiento(Tratamiento tratamiento) {
        return tratamientoRepo.save(tratamiento);
    }

    @Override
    public Tratamiento actualizarTratamiento(Tratamiento tratamiento) throws  ExcepcionServicios {
        Optional<Tratamiento> guardado = tratamientoRepo.findById(tratamiento.getId());

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(TRATAMIENTO_NOEXISTE);
        }

        return tratamientoRepo.save(tratamiento);
    }

    @Override
    public void eliminarTratamiento(Integer codigo) throws  ExcepcionServicios {
        Optional<Tratamiento> guardado = tratamientoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(TRATAMIENTO_NOEXISTE);
        }

        tratamientoRepo.delete(guardado.get());
    }

    @Override
    public List<Tratamiento> listarTratamientos() {
        return tratamientoRepo.findAll();
    }

    @Override
    public Tratamiento obtenerTratamiento(Integer codigo) throws  ExcepcionServicios {
        Optional<Tratamiento> guardado = tratamientoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new  ExcepcionServicios(TRATAMIENTO_NOEXISTE);
        }

        return guardado.get();
    }


}
