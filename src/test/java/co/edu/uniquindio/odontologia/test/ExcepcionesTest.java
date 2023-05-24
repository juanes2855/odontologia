package co.edu.uniquindio.odontologia.test;

import co.edu.uniquindio.odontologia.exceptions.ExcepcionEjecucion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
@Transactional
class ExcepcionesTest {

    @Test
    void testConstructor() {
        Exception exception = new Exception("Mensaje de prueba");
        ExcepcionEjecucion excepcionEjecucion = new ExcepcionEjecucion(exception);

        assertNotNull(excepcionEjecucion);
    }
}

