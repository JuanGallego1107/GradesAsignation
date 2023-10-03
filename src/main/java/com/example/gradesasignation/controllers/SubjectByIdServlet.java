package com.example.gradesasignation.controllers;

import com.example.gradesasignation.mapper.dtos.SubjectDto;
import com.example.gradesasignation.mapper.dtos.TeacherDto;
import com.example.gradesasignation.service.SubjectService;
import com.example.gradesasignation.service.TeacherService;
import com.example.gradesasignation.service.impl.SubjectServiceImpl;
import com.example.gradesasignation.service.impl.TeacherServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/subjectbyid")
public class SubjectByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        SubjectService service = new SubjectServiceImpl(conn);
        String idString = req.getParameter("id");
        try {
            Long id = Long.parseLong(idString);
            SubjectDto subject = service.byId(id);
                try (PrintWriter out = resp.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println(" <head>");
                    out.println(" <meta charset=\"UTF-8\">");
                    out.println(" <title>Consulta por ID</title>");
                    out.println(" </head>");
                    out.println(" <body>");
                    out.println(" <h1>Asignatura encontrada!</h1>");
                    out.println(" <h3>Este es la asignatura con id "+id+" :  "+ subject + "</h3>");
                    out.println(" </body>");
                    out.println("</html>");
                }
        } catch (Exception e) {
        resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No existe una asignatura con este id");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
    }
}
