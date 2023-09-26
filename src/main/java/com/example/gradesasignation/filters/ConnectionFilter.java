package com.example.gradesasignation.filters;

import com.example.gradesasignation.exceptions.ServiceJdbcException;
import com.example.gradesasignation.utils.ConexionBD;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConnectionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try (Connection conn = ConexionBD.getInstance()) {
//Si la modalidad de confirmación automática (autocommit) está activada, el gestor
// de bases de datos ejecuta una operación de confirmación después de la ejecución
// de cada sentencia de SQL. (se entenderá mejor en la siguiente practica este
// concepto)
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            try {
                request.setAttribute("conn", conn);
                chain.doFilter(request, response);
                conn.commit();
            } catch (SQLException | ServiceJdbcException e) {
                conn.rollback();
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
