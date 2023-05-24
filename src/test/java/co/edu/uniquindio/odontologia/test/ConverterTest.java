package co.edu.uniquindio.odontologia.test;

import co.edu.uniquindio.odontologia.converter.OdontologoConverter;
import co.edu.uniquindio.odontologia.converter.PacienteConverter;
import co.edu.uniquindio.odontologia.entidades.Odontologo;
import co.edu.uniquindio.odontologia.entidades.Paciente;
import co.edu.uniquindio.odontologia.exceptions.ExcepcionEjecucion;
import co.edu.uniquindio.odontologia.servicios.OdontologoServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
@Transactional
class ConverterTest {

    @Autowired
    private OdontologoServicio odontologoServicio;


    @Test
    void testGetAsObjectOdontologo_Exception() {
        OdontologoConverter converter = new OdontologoConverter();
        FacesContext context = null; // Puedes utilizar un mock de FacesContext si es necesario
        UIComponent component = null; // Puedes utilizar un mock de UIComponent si es necesario
        String value = "invalid"; // Valor de prueba inválido

        // Verificar que se lanza una excepción ExcepcionEjecucion al intentar convertir el valor inválido
        assertThrows(ExcepcionEjecucion.class, () -> converter.getAsObject(context, component, value));
    }

    @Test
    void testGetAsStringOdontologo_Null() {
        OdontologoConverter converter = new OdontologoConverter();
        FacesContext context = null; // Puedes utilizar un mock de FacesContext si es necesario
        UIComponent component = null; // Puedes utilizar un mock de UIComponent si es necesario
        Odontologo value = null; // Valor de prueba nulo

        String result = converter.getAsString(context, component, value);

        // Verificar que el resultado sea una cadena vacía
        assertEquals("", result);
    }


    @Test
    void testGetAsObjectPaciente_Exception() {
        PacienteConverter converter = new PacienteConverter();
        FacesContext context = null; // Puedes utilizar un mock de FacesContext si es necesario
        UIComponent component = null; // Puedes utilizar un mock de UIComponent si es necesario
        String value = "invalid"; // Valor de prueba inválido

        // Verificar que se lanza una excepción ExcepcionEjecucion al intentar convertir el valor inválido
        assertThrows(ExcepcionEjecucion.class, () -> converter.getAsObject(context, component, value));
    }

    @Test
    void testGetAsStringPaciente_Null() {
        PacienteConverter converter = new PacienteConverter();
        FacesContext context = null; // Puedes utilizar un mock de FacesContext si es necesario
        UIComponent component = null; // Puedes utilizar un mock de UIComponent si es necesario
        Paciente value = null; // Valor de prueba nulo

        String result = converter.getAsString(context, component, value);

        // Verificar que el resultado sea una cadena vacía
        assertEquals("", result);
    }
}

