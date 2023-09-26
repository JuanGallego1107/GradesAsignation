package com.example.gradesasignation.controllers;

import com.example.gradesasignation.mapper.dtos.StudentDto;
import com.example.gradesasignation.mapper.dtos.TeacherDto;
import com.example.gradesasignation.repository.Impl.TeacherRepositoryImpl;
import com.example.gradesasignation.repository.Impl.TeacherRepositoryLogicImpl;
import com.example.gradesasignation.service.StudentService;
import com.example.gradesasignation.service.TeacherService;
import com.example.gradesasignation.service.impl.StudentServiceImpl;
import com.example.gradesasignation.service.impl.TeacherServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(name = "teacherController", value = "/teacher-form")
public class TeacherController extends HttpServlet {

    private String message;

    public void init(){
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Connection conn = (Connection) request.getAttribute("conn");
        TeacherService service = new TeacherServiceImpl(conn);
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("h1>Teachers</h1>");
        out.println(service.teacherList());
        out.println("</body></html>");
    }

    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        Connection conn = (Connection) req.getAttribute("conn");
        TeacherService service = new TeacherServiceImpl(conn);
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        TeacherDto teacher = new TeacherDto(1L, name, email);
        service.update(teacher);
        System.out.println(service.teacherList());

        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Resultado form</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Resultado form!</h1>");

            out.println("        <ul>");
            out.println("            <li>Name: " + name + "</li>");
            out.println("            <li>Email: " + email + "</li>");
            out.println("        </ul>");
            out.println("    </body>");
            out.println("</html>");
        }
    }
    public void destroy() {

    }
}
