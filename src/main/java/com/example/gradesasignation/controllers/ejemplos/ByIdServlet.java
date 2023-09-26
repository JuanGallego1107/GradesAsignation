package com.example.gradesasignation.controllers.ejemplos;

import com.example.gradesasignation.mapper.dtos.StudentDto;
import com.example.gradesasignation.repository.Impl.StudentRepositoryImpl;
import com.example.gradesasignation.repository.Impl.StudentRepositoryLogicImpl;
import com.example.gradesasignation.service.StudentService;
import com.example.gradesasignation.service.impl.StudentServiceImpl;
import com.example.gradesasignation.utils.ConexionBD;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/byid")
public class ByIdServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        StudentService service = new StudentServiceImpl(conn);
        String idString = req.getParameter("id");
        try {
            Long id = Long.parseLong(idString);
            StudentDto student = service.byId(id);
            if (student != null) {
                try (PrintWriter out = resp.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println(" <head>");
                    out.println(" <meta charset=\"UTF-8\">");
                    out.println(" <title>Consulta por ID</title>");
                    out.println(" </head>");
                    out.println(" <body>");
                    out.println(" <h1>Estudiante encontrado!</h1>");
                    out.println(" <h3>Este es el estudiante con id "+id+" :  "+ student + "</h3>");
                    out.println(" </body>");
                    out.println("</html>");
                }
            } else {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No existe un estudiante con este id");
            }
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "El 'id' ingresado no es un número válido.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
    }
}
