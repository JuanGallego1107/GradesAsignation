package com.example.gradesasignation.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class ApplicationListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {
    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("inicia la aplicación!");
        servletContext = sce.getServletContext();
        servletContext.setAttribute("mensaje", "Hola a todos desde la application!");
    }
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("inicializando el request!");
        sre.getServletRequest().setAttribute("mensaje", "guardando algún valor para el request");
    }

    /*
    1. String mensajeRequest = (String) req.getAttribute("mensaje");
    String mensajeApp = (String) getServletContext().getAttribute("mensaje");

    En la primera linea estamos haciendo un cast de String de un atributo llamado mensaje que en este caso representa
    una solicitud HTTTP de una aplicacion web , la cual se encarga de inicializar la aplicacion y se ejecuta una sola vez.

    En la segunda linea , estamos haciendo el mismo proceso de cast , pero invocamos un atributo de tipo servlet context
    que en este caso se usa para inicializar un request

    2. En un request session se podria aplicar para la creacion o destruccion de las sesiones de una cuenta de usuario,
    por otro lado en el servlet context los usariamos para toda interaccion usuario-servidor que se presentara en este
    caso para relizar diferentes tipos de consultas de notas, estudiantes , profesores , etc...

    */

}
