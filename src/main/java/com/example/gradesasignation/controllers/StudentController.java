package com.example.gradesasignation.controllers;

import com.example.gradesasignation.domain.models.Student;
import com.example.gradesasignation.mapper.dtos.StudentDto;
import com.example.gradesasignation.repository.Impl.StudentRepositoryImpl;
import com.example.gradesasignation.repository.Impl.StudentRepositoryLogicImpl;
import com.example.gradesasignation.service.StudentService;
import com.example.gradesasignation.service.impl.StudentServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "studentController", value = "/student-form")
public class StudentController extends HttpServlet {

    private String message;

    public void init(){
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Connection conn = (Connection) request.getAttribute("conn");
        StudentService service = new StudentServiceImpl(conn);
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("h1>Students</h1>");
        out.println(service.studentList());
        out.println("</body></html>");
    }

    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        Connection conn = (Connection) req.getAttribute("conn");
        StudentServiceImpl service = new StudentServiceImpl(conn);
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String degree = req.getParameter("degree");
        String semester = req.getParameter("semester");
        service.update(new StudentDto(2L,name,email,degree,semester));
        System.out.println(service.studentList());

        try(PrintWriter out = resp.getWriter()) {

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
            out.println("            <li>Degree: " + degree + "</li>");
            out.println("            <li>Semester: " + semester + "</li>");
            out.println("        </ul>");
            out.println("    </body>");
            out.println("</html>");
        }
    }
    public void destroy(){

    }
}
