package co.edu.uniquindio.odontologia.test;

import co.edu.uniquindio.odontologia.entidades.Odontologo;
import co.edu.uniquindio.odontologia.servicios.OdontologoServicio;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uniquindio.odontologia.entidades.*;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
public class OdontologoServicioTest {

    @Autowired
    private OdontologoServicio odontologoServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void loginTest() {
        try {
            Odontologo odontologo = odontologoServicio.login("luisa.lopez@example.com", "secreto456");
            assertNotNull(odontologo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearAgendaTest() throws Exception {
        Odontologo odontologo = odontologoServicio.obtenerOdontologo(1);
        Paciente paciente = odontologoServicio.obtenerPaciente(11111111);
        Agenda agenda = Agenda.builder().hora(LocalTime.of(12,30)).fecha(LocalDate.of(2023,5,12)).estado("Por confirmar").odontologo(odontologo).paciente(paciente).build();
        Agenda createdAgenda = odontologoServicio.crearAgenda(agenda);
        assertNotNull(createdAgenda);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearOdontologoTest() throws Exception {
        Odontologo odontologo = Odontologo.builder().nombre("p").telefono("1").direccion("1").correo("1@gf.com").password("1234").build();
        Odontologo createdoOdontologo = odontologoServicio.crearOdontologo(odontologo);
        assertNotNull(createdoOdontologo);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarAgendaTest() {
        try {
            Agenda agenda = odontologoServicio.obtenerAgenda(1);
            agenda.setEstado("Sin confirmar");
            Agenda updatedAgenda = odontologoServicio.actualizarAgenda(agenda);
            assertNotNull(updatedAgenda);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarAgendaTest() {
        try {
            odontologoServicio.eliminarAgenda(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarAgendasTest() {
        List<Agenda> agendas = odontologoServicio.listarAgendas();
        assertNotNull(agendas);
        assertFalse(agendas.isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearHistorialCitaTest() throws Exception {
        Agenda agenda = odontologoServicio.obtenerAgenda(1);
        Paciente paciente = odontologoServicio.obtenerPaciente(11111111);
        Tratamiento tratamiento = Tratamiento.builder().nombre("Ortoplan").descripcion("Planta de ortodoncia paciente").build();
        HistorialCita historialCita = HistorialCita.builder().asistencia("Por confirmar").descripcion("Tratamiento ortodoncia")
                .agenda(agenda).tratamiento(tratamiento).paciente(paciente).build();
        HistorialCita createdHistorialCita = odontologoServicio.crearHistorialCita(historialCita);
        assertNotNull(createdHistorialCita);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarHistorialCitaTest() {
        try {
            HistorialCita historialCita = odontologoServicio.obtenerHistorialCita(1);
            historialCita.setAsistencia("No asistio");
            HistorialCita updatedHistorialCita = odontologoServicio.actualizarHistorialCita(historialCita);
            assertNotNull(updatedHistorialCita);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarHistorialCitaTest() {
        try {
            odontologoServicio.eliminarHistorialCita(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHistorialCitasTest() {
        List<HistorialCita> historialCitas = odontologoServicio.listarHistorialCitas();
        assertNotNull(historialCitas);
        assertFalse(historialCitas.isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHistorialCitaTest() {
        try {
            HistorialCita historialCita = odontologoServicio.obtenerHistorialCita(1);
            assertNotNull(historialCita);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearHistorialMedicoTest() {
        HistorialMedico historialMedico = HistorialMedico.builder()
                // Set properties for the historialMedico object
                .build();
        HistorialMedico createdHistorialMedico = odontologoServicio.crearHistorialMedico(historialMedico);
        assertNotNull(createdHistorialMedico);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarHistorialMedicoTest() {
        try {
            HistorialMedico historialMedico = odontologoServicio.obtenerHistorialMedico(1);
            // Update properties for the historialMedico object
            HistorialMedico updatedHistorialMedico = odontologoServicio.actualizarHistorialMedico(historialMedico);
            assertNotNull(updatedHistorialMedico);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarHistorialMedicoTest() {
        try {
            odontologoServicio.eliminarHistorialMedico(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHistorialMedicosTest() {
        List<HistorialMedico> historialMedicos = odontologoServicio.listarHistorialMedicos();
        assertNotNull(historialMedicos);
        assertFalse(historialMedicos.isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearConcentimientoTest() throws Exception {
        Paciente paciente = odontologoServicio.obtenerPaciente(12345678);
        Concentimiento concentimiento = Concentimiento.builder().nombre(paciente.getNombre()).procedimiento("Ortodoncia").riesgos("dientes").build();
        Concentimiento createdConcentimiento = odontologoServicio.crearConcentimiento(concentimiento);
        assertNotNull(createdConcentimiento);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarConcentimientoTest() {
        try {
            Concentimiento concentimiento = odontologoServicio.obtenerConcentimiento(1);
            // Update properties for the concentimiento object
            Concentimiento updatedConcentimiento = odontologoServicio.actualizarConcentimiento(concentimiento);
            assertNotNull(updatedConcentimiento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarConcentimientoTest() {
        try {
            odontologoServicio.eliminarConcentimiento(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarConcentimientosTest() {
        List<Concentimiento> concentimientos = odontologoServicio.listarConcentimientos();
        assertNotNull(concentimientos);
        assertFalse(concentimientos.isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerConcentimientoTest() {
        try {
            Concentimiento concentimiento = odontologoServicio.obtenerConcentimiento(1);
            assertNotNull(concentimiento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearHistorialTratamientoTest() throws Exception {
        Paciente paciente = odontologoServicio.obtenerPaciente(11111111);
        Tratamiento tratamiento = odontologoServicio.obtenerTratamiento(1);
        HistorialTratamiento historialTratamiento = HistorialTratamiento.builder()
                .estado("En proceso").paciente(paciente).tratamiento(tratamiento)
                .build();
        HistorialTratamiento createdHistorialTratamiento = odontologoServicio.crearHistorialTratamiento(historialTratamiento);
        assertNotNull(createdHistorialTratamiento);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarHistorialTratamientoTest() {
        try {
            HistorialTratamiento historialTratamiento = odontologoServicio.obtenerHistorialTratamiento(1);
            historialTratamiento.setEstado("En proceso");
            HistorialTratamiento updatedHistorialTratamiento = odontologoServicio.actualizarHistorialTratamiento(historialTratamiento);
            assertNotNull(updatedHistorialTratamiento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarHistorialTratamientoTest() {
        try {
            odontologoServicio.eliminarHistorialTratamiento(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHistorialTratamientosTest() {
        List<HistorialTratamiento> historialTratamientos = odontologoServicio.listarHistorialTratamientos();
        assertNotNull(historialTratamientos);
        assertFalse(historialTratamientos.isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHistorialTratamientoTest() {
        try {
            HistorialTratamiento historialTratamiento = odontologoServicio.obtenerHistorialTratamiento(1);
            assertNotNull(historialTratamiento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void crearInfoBasicaTest() {
        InfoBasica infoBasica = InfoBasica.builder()
                // Set properties for the infoBasica object
                .build();
        InfoBasica createdInfoBasica = odontologoServicio.crearInfoBasica(infoBasica);
        assertNotNull(createdInfoBasica);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarInfoBasicaTest() {
        try {
            InfoBasica infoBasica = odontologoServicio.obtenerInfoBasica(1);
            // Update properties for the infoBasica object
            InfoBasica updatedInfoBasica = odontologoServicio.actualizarInfoBasica(infoBasica);
            assertNotNull(updatedInfoBasica);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarInfoBasicaTest() {
        try {
            odontologoServicio.eliminarInfoBasica(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarInfoBasicasTest() {
        List<InfoBasica> infoBasicas = odontologoServicio.listarInfoBasicas();
        assertNotNull(infoBasicas);
        assertFalse(infoBasicas.isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearInstrumentalTest() {
        Instrumental instrumental = Instrumental.builder()
                // Set properties for the instrumental object
                .build();
        Instrumental createdInstrumental = odontologoServicio.crearInstrumental(instrumental);
        assertNotNull(createdInstrumental);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarInstrumentalTest() {
        try {
            Instrumental instrumental = odontologoServicio.obtenerInstrumental(1);
            // Update properties for the instrumental object
            Instrumental updatedInstrumental = odontologoServicio.actualizarInstrumental(instrumental);
            assertNotNull(updatedInstrumental);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarInstrumentalTest() {
        try {
            odontologoServicio.eliminarInstrumental(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarInstrumentalesTest() {
        List<Instrumental> instrumentales = odontologoServicio.listarInstrumentales();
        assertNotNull(instrumentales);
        assertFalse(instrumentales.isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerInstrumentalTest() {
        try {
            Instrumental instrumental = odontologoServicio.obtenerInstrumental(1);
            assertNotNull(instrumental);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // Pruebas para Odontograma
    @Test
    @Sql("classpath:dataset.sql")
    public void crearOdontogramaTest() {
        Odontograma odontograma = Odontograma.builder()
                // Set properties for the odontograma object
                .build();
        Odontograma createdOdontograma = odontologoServicio.crearOdontograma(odontograma);
        assertNotNull(createdOdontograma);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarOdontogramaTest() {
        try {
            Odontograma odontograma = odontologoServicio.obtenerOdontograma(1);
            // Update properties for the odontograma object
            Odontograma updatedOdontograma = odontologoServicio.actualizarOdontograma(odontograma);
            assertNotNull(updatedOdontograma);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarOdontogramaTest() {
        try {
            odontologoServicio.eliminarOdontograma(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarOdontogramasTest() {
        List<Odontograma> odontogramas = odontologoServicio.listarOdontogramas();
        assertNotNull(odontogramas);
        assertFalse(odontogramas.isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerOdontogramaTest() {
        try {
            Odontograma odontograma = odontologoServicio.obtenerOdontograma(1);
            assertNotNull(odontograma);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Pruebas para Paciente
    @Test
    @Sql("classpath:dataset.sql")
    public void crearPacienteTest() {
        Paciente paciente = Paciente.builder().documento(1004978123).nombre("Juan Rodrigo").telefono("321654")
                .genero("H").fechaNacimiento(LocalDate.of(1990,10,12)).correo("juanrodri@gmail.com").build();
        Paciente createdPaciente = odontologoServicio.crearPaciente(paciente);
        assertNotNull(createdPaciente);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarPacienteTest() {
        try {
            Paciente paciente = odontologoServicio.obtenerPaciente(12345678);
            paciente.setTelefono("556-1234");
            Paciente updatedPaciente = odontologoServicio.actualizarPaciente(paciente);
            Assertions.assertEquals("556-1234", updatedPaciente.getTelefono());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarPacienteTest() {
        try {
            odontologoServicio.eliminarPaciente(12345678);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPacientesTest() {
        List<Paciente> pacientes = odontologoServicio.listarPacientes();
        assertNotNull(pacientes);
        assertFalse(pacientes.isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPacienteTest() {
        try {
            Paciente paciente = odontologoServicio.obtenerPaciente(12345678);
            assertNotNull(paciente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void crearTratamientoTest() {
        Tratamiento tratamiento = Tratamiento.builder()
                // Set properties for the tratamiento object
                .build();
        Tratamiento createdTratamiento = odontologoServicio.crearTratamiento(tratamiento);
        assertNotNull(createdTratamiento);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarTratamientoTest() {
        try {
            Tratamiento tratamiento = odontologoServicio.obtenerTratamiento(1);
            // Update properties for the tratamiento object
            Tratamiento updatedTratamiento = odontologoServicio.actualizarTratamiento(tratamiento);
            assertNotNull(updatedTratamiento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarTratamientoTest() {
        try {
            odontologoServicio.eliminarTratamiento(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarTratamientosTest() {
        List<Tratamiento> tratamientos = odontologoServicio.listarTratamientos();
        assertNotNull(tratamientos);
        assertFalse(tratamientos.isEmpty());
    }
}
