package co.edu.uniquindio.odontologia.filtros;

import co.edu.uniquindio.odontologia.bean.SeguridadBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SeguridadFiltro implements Filter {

    public static final String PAGINA_INICIO = "/index.xhtml";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            final HttpServletRequest request = (HttpServletRequest) servletRequest;
            final HttpServletResponse response = (HttpServletResponse) servletResponse;
            final String requestURI = request.getRequestURI();
            //Obtenemos el objeto seguridadBean de la sesión actual
            SeguridadBean userManager = (SeguridadBean) request.getSession().getAttribute("seguridadBean");

            //Aplicar el filtro a esta carpeta
            if (requestURI.startsWith("/odontologo/") ) {


                if (userManager != null) {
                    if (userManager.isAutenticado() && userManager.getTipoSession().equals("odontologo")) {
                        //El usuario está logueado entonces si puede ver la página solicitada
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        //El usuario no está logueado, entonces se redirecciona al inicio
                        response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                    }
                } else {
                    //El usuario no está logueado, entonces se redirecciona al inicio
                    response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}