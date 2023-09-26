package com.example.gradesasignation.controllers;

import com.example.gradesasignation.mapper.dtos.SubjectDto;
import com.example.gradesasignation.mapper.dtos.TeacherDto;
import com.example.gradesasignation.repository.Impl.SubjectRepositoryLogicImpl;
import com.example.gradesasignation.service.StudentService;
import com.example.gradesasignation.service.SubjectService;
import com.example.gradesasignation.service.impl.StudentServiceImpl;
import com.example.gradesasignation.service.impl.SubjectServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(name = "subjectController", value = "/subject-form")
public class SubjectController extends HttpServlet {

    private String message;

    public void init(){
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Connection conn = (Connection) request.getAttribute("conn");
        SubjectService service = new SubjectServiceImpl(conn);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("h1>Teachers</h1>");
        out.println(service.subjectList());
        out.println("</body></html>");
    }

    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        Connection conn = (Connection) req.getAttribute("conn");
        SubjectService service = new SubjectServiceImpl(conn);
        String name = req.getParameter("name");
        service.update(new SubjectDto(3L, name));
        System.out.println(service.subjectList());

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
            out.println("        </ul>");
            out.println("    </body>");
            out.println("</html>");
        }
    }
    public void destroy() {

    }
}
