package com.example.gradesasignation.controllers;

import com.example.gradesasignation.mapper.dtos.StudentDto;
import com.example.gradesasignation.repository.Impl.StudentRepositoryLogicImpl;
import com.example.gradesasignation.service.StudentService;
import com.example.gradesasignation.service.impl.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private StudentRepositoryLogicImpl studentRepository;
    private StudentService service;

    public LoginServlet(){
        studentRepository = new StudentRepositoryLogicImpl();
        service = new StudentServiceImpl(studentRepository);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String id = req.getParameter("id");
        if (id.equals(id)) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>Login correcto</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h1>Login correcto!</h1>");
                out.println(" <h3>Este es el estudiante con id:  "+ id + "</h3>");
                out.println(" </body>");
                out.println("</html>");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No existe un estudiante con este id");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
    }
}
