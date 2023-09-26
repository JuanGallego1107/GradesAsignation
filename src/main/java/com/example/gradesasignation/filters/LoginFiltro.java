package com.example.gradesasignation.filters;

import com.example.gradesasignation.service.LoginService;
import com.example.gradesasignation.service.impl.LoginServiceSessionImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

import java.util.logging.LogRecord;

//@WebFilter({"/student.jsp"})
public class LoginFiltro implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain
            chain) throws IOException, ServletException {
        LoginService service = new LoginServiceSessionImpl();
        Optional<String> username = service.getUsername((HttpServletRequest)
                request);
        if (username.isPresent()) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "No estás autorizado para ingresar a esta página!");
        }
    }
}
