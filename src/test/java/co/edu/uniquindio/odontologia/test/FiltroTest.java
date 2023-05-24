package co.edu.uniquindio.odontologia.test;
import co.edu.uniquindio.odontologia.bean.SeguridadBean;
import co.edu.uniquindio.odontologia.filtros.SeguridadFiltro;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;
@SpringBootTest
@Transactional
class FiltroTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    @Mock
    private HttpSession session;

    @Test
    void testDoFilter_Autenticado_Odontologo() throws Exception {
        MockitoAnnotations.openMocks(this);

        when(request.getRequestURI()).thenReturn("/odontologo/");
        when(request.getSession()).thenReturn(session);

        SeguridadBean userManager = new SeguridadBean();
        userManager.setAutenticado(true);
        userManager.setTipoSesion("odontologo");
        when(session.getAttribute("seguridadBean")).thenReturn(userManager);

        SeguridadFiltro filtro = new SeguridadFiltro();
        filtro.doFilter(request, response, filterChain);

        verify(filterChain).doFilter(request, response);
        verify(response, never()).sendRedirect(anyString());
    }

}

