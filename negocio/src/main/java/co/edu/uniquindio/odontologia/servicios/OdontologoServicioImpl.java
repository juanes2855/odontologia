package co.edu.uniquindio.odontologia.servicios;

import co.edu.uniquindio.odontologia.entidades.*;
import co.edu.uniquindio.odontologia.repo.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServicioImpl implements OdontologoServicio {

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
    public Odontologo login(String correo, String password) throws Exception {
        Odontologo odontologo = odontologoRepo.findByCorreo(correo).orElse(null);
        if (odontologo != null) {
            //   StrongPasswordEncryptor spe = new StrongPasswordEncryptor();

            //    if (!spe.checkPassword(password, odontologo.getPassword())) {
            //        throw new Exception("La contraseña es incorrecta");
            //    }
            if (!password.equals(odontologo.getPassword())) {
                throw new Exception("La contraseña es incorrecta");
            }

        }
        return odontologo;
    }

    @Override
    public Odontologo obtenerOdontologo(int id) throws Exception {
        Optional<Odontologo> guardado = odontologoRepo.findById(id);

        if (guardado.isEmpty()) {
            throw new Exception("El odontologo no existe");
        }

        return guardado.get();
    }

    @Override
    public Agenda crearAgenda(Agenda agenda) {
        return agendaRepo.save(agenda);
    }

    @Override
    public Agenda actualizarAgenda(Agenda agenda) throws Exception {
        Optional<Agenda> guardado = agendaRepo.findById(agenda.getId());

        if (guardado.isEmpty()) {
            throw new Exception("La agenda no existe");
        }

        return agendaRepo.save(agenda);
    }

    @Override
    public void eliminarAgenda(Integer id) throws Exception {
        Optional<Agenda> guardado = agendaRepo.findById(id);

        if (guardado.isEmpty()) {
            throw new Exception("La agenda no existe");
        }

        agendaRepo.delete(guardado.get());
    }

    @Override
    public Agenda obtenerAgenda(Integer idAgenda) throws Exception {
        Optional<Agenda> guardado = agendaRepo.findById(idAgenda);

        if (guardado.isEmpty()) {
            throw new Exception("La agenda no existe");
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
    public HistorialCita actualizarHistorialCita(HistorialCita historialCita) throws Exception {
        Optional<HistorialCita> guardado = historialCitaRepo.findById(historialCita.getId());

        if (guardado.isEmpty()) {
            throw new Exception("El historial de cita no existe");
        }

        return historialCitaRepo.save(historialCita);
    }

    @Override
    public void eliminarHistorialCita(Integer id) throws Exception {
        Optional<HistorialCita> guardado = historialCitaRepo.findById(id);

        if (guardado.isEmpty()) {
            throw new Exception("El historial Cita no existe");
        }

        historialCitaRepo.delete(guardado.get());
    }

    @Override
    public List<HistorialCita> listarHistorialCitas() {
        return historialCitaRepo.findAll();
    }

    @Override
    public HistorialCita obtenerHistorialCita(Integer id) throws Exception {
        Optional<HistorialCita> guardado = historialCitaRepo.findById(id);

        if (guardado.isEmpty()) {
            throw new Exception("El historial Cita no existe");
        }

        return guardado.get();
    }

    @Override
    public HistorialMedico crearHistorialMedico(HistorialMedico historialMedico) {
        return historialMedicoRepo.save(historialMedico);
    }

    @Override
    public HistorialMedico actualizarHistorialMedico(HistorialMedico historialMedico) throws Exception {
        Optional<HistorialMedico> guardado = historialMedicoRepo.findById(historialMedico.getId());

        if (guardado.isEmpty()) {
            throw new Exception("El historial medico no existe");
        }

        return historialMedicoRepo.save(historialMedico);
    }

    @Override
    public void eliminarHistorialMedico(Integer codigo) throws Exception {
        Optional<HistorialMedico> guardado = historialMedicoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El historial medico no existe");
        }

        historialMedicoRepo.delete(guardado.get());
    }

    @Override
    public List<HistorialMedico> listarHistorialMedicos() {
        return historialMedicoRepo.findAll();
    }

    @Override
    public HistorialMedico obtenerHistorialMedico(Integer codigo) throws Exception {
        Optional<HistorialMedico> guardado = historialMedicoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El historial medico no existe");
        }

        return guardado.get();
    }

    @Override
    public Concentimiento crearConcentimiento(Concentimiento concentimiento) {
        return concentimientoRepo.save(concentimiento);
    }

    @Override
    public Concentimiento actualizarConcentimiento(Concentimiento concentimiento) throws Exception {
        Optional<Concentimiento> guardado = concentimientoRepo.findById(concentimiento.getId());

        if (guardado.isEmpty()) {
            throw new Exception("El concentimiento no existe");
        }

        return concentimientoRepo.save(concentimiento);
    }

    @Override
    public void eliminarConcentimiento(Integer codigo) throws Exception {
        Optional<Concentimiento> guardado = concentimientoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El concentimiento no existe");
        }

        concentimientoRepo.delete(guardado.get());
    }

    @Override
    public List<Concentimiento> listarConcentimientos() {
        return concentimientoRepo.findAll();
    }

    @Override
    public Concentimiento obtenerConcentimiento(Integer codigo) throws Exception {
        Optional<Concentimiento> guardado = concentimientoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El concentimiento no existe");
        }

        return guardado.get();
    }

    @Override
    public HistorialTratamiento crearHistorialTratamiento(HistorialTratamiento historialTratamiento) {
        return historialTratamientoRepo.save(historialTratamiento);
    }

    @Override
    public HistorialTratamiento actualizarHistorialTratamiento(HistorialTratamiento historialTratamiento) throws Exception {
        Optional<HistorialTratamiento> guardado = historialTratamientoRepo.findById(historialTratamiento.getId());

        if (guardado.isEmpty()) {
            throw new Exception("El historial de Tratamiento no existe");
        }

        return historialTratamientoRepo.save(historialTratamiento);
    }

    @Override
    public void eliminarHistorialTratamiento(Integer codigo) throws Exception {
        Optional<HistorialTratamiento> guardado = historialTratamientoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El historial de Tratamiento no existe");
        }

        historialTratamientoRepo.delete(guardado.get());
    }

    @Override
    public List<HistorialTratamiento> listarHistorialTratamientos() {
        return historialTratamientoRepo.findAll();
    }

    @Override
    public HistorialTratamiento obtenerHistorialTratamiento(Integer codigo) throws Exception {
        Optional<HistorialTratamiento> guardado = historialTratamientoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El historial de Tratamiento no existe");
        }

        return guardado.get();
    }

    @Override
    public InfoBasica crearInfoBasica(InfoBasica infoBasica) {
        return infoBasicaRepo.save(infoBasica);
    }

    @Override
    public InfoBasica actualizarInfoBasica(InfoBasica infoBasica) throws Exception {
        Optional<InfoBasica> guardado = infoBasicaRepo.findById(infoBasica.getId());

        if (guardado.isEmpty()) {
            throw new Exception("La información basica no existe");
        }

        return infoBasicaRepo.save(infoBasica);
    }

    @Override
    public void eliminarInfoBasica(Integer codigo) throws Exception {
        Optional<InfoBasica> guardado = infoBasicaRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("La información basica no existe");
        }

        infoBasicaRepo.delete(guardado.get());
    }

    @Override
    public List<InfoBasica> listarInfoBasicas() {
        return infoBasicaRepo.findAll();
    }

    @Override
    public InfoBasica obtenerInfoBasica(Integer codigo) throws Exception {
        Optional<InfoBasica> guardado = infoBasicaRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("La información basica no existe");
        }

        return guardado.get();
    }

    @Override
    public Instrumental crearInstrumental(Instrumental instrumental) {
        return instrumentalRepo.save(instrumental);
    }

    @Override
    public Instrumental actualizarInstrumental(Instrumental instrumental) throws Exception {
        Optional<Instrumental> guardado = instrumentalRepo.findById(instrumental.getId());

        if (guardado.isEmpty()) {
            throw new Exception("El instrumental no existe");
        }

        return instrumentalRepo.save(instrumental);
    }

    @Override
    public void eliminarInstrumental(Integer codigo) throws Exception {
        Optional<Instrumental> guardado = instrumentalRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El instrumental no existe");
        }

        instrumentalRepo.delete(guardado.get());
    }

    @Override
    public List<Instrumental> listarInstrumentales() {
        return instrumentalRepo.findAll();
    }

    @Override
    public Instrumental obtenerInstrumental(Integer codigo) throws Exception {
        Optional<Instrumental> guardado = instrumentalRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El instrumental no existe");
        }

        return guardado.get();
    }

    @Override
    public Odontograma crearOdontograma(Odontograma odontograma) {
        return odontogramaRepo.save(odontograma);
    }

    @Override
    public Odontograma actualizarOdontograma(Odontograma odontograma) throws Exception {
        Optional<Odontograma> guardado = odontogramaRepo.findById(odontograma.getId());

        if (guardado.isEmpty()) {
            throw new Exception("El odontograma no existe");
        }

        return odontogramaRepo.save(odontograma);
    }

    @Override
    public void eliminarOdontograma(Integer codigo) throws Exception {
        Optional<Odontograma> guardado = odontogramaRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El odontograma no existe");
        }

        odontogramaRepo.delete(guardado.get());
    }

    @Override
    public List<Odontograma> listarOdontogramas() {
        return odontogramaRepo.findAll();
    }

    @Override
    public Odontograma obtenerOdontograma(Integer codigo) throws Exception {
        Optional<Odontograma> guardado = odontogramaRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El odontograma no existe");
        }

        return guardado.get();
    }

    @Override
    public Paciente crearPaciente(Paciente paciente) {
        return pacienteRepo.save(paciente);
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) throws Exception {
        Optional<Paciente> guardado = pacienteRepo.findById(paciente.getDocumento());

        if (guardado.isEmpty()) {
            throw new Exception("El paciente no existe");
        }

        return pacienteRepo.save(paciente);
    }

    @Override
    public void eliminarPaciente(Integer codigo) throws Exception {
        Optional<Paciente> guardado = pacienteRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El paciente no existe");
        }

        pacienteRepo.delete(guardado.get());
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepo.findAll();
    }

    @Override
    public Paciente obtenerPaciente(Integer codigo) throws Exception {
        Optional<Paciente> guardado = pacienteRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El paciente no existe");
        }

        return guardado.get();
    }

    @Override
    public Tratamiento crearTratamiento(Tratamiento tratamiento) {
        return tratamientoRepo.save(tratamiento);
    }

    @Override
    public Tratamiento actualizarTratamiento(Tratamiento tratamiento) throws Exception {
        Optional<Tratamiento> guardado = tratamientoRepo.findById(tratamiento.getId());

        if (guardado.isEmpty()) {
            throw new Exception("El tratamiento no existe");
        }

        return tratamientoRepo.save(tratamiento);
    }

    @Override
    public void eliminarTratamiento(Integer codigo) throws Exception {
        Optional<Tratamiento> guardado = tratamientoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El tratamiento no existe");
        }

        tratamientoRepo.delete(guardado.get());
    }

    @Override
    public List<Tratamiento> listarTratamientos() {
        return tratamientoRepo.findAll();
    }

    @Override
    public Tratamiento obtenerTratamiento(Integer codigo) throws Exception {
        Optional<Tratamiento> guardado = tratamientoRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El tratamiento no existe");
        }

        return guardado.get();
    }


}
