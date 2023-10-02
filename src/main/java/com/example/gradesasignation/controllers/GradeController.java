package com.example.gradesasignation.controllers;

import com.example.gradesasignation.mapper.dtos.GradesDto;
import com.example.gradesasignation.mapper.dtos.StudentDto;
import com.example.gradesasignation.service.GradesService;
import com.example.gradesasignation.service.StudentService;
import com.example.gradesasignation.service.impl.GradesServiceImpl;
import com.example.gradesasignation.service.impl.StudentServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/grades-form")
public class GradeController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Connection conn = (Connection) request.getAttribute("conn");
        GradesService service = new GradesServiceImpl(conn);
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("h1>Students</h1>");
        out.println(service.gradesList());
        out.println("</body></html>");
    }

    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        Connection conn = (Connection) req.getAttribute("conn");
        GradesService service = new GradesServiceImpl(conn);
        String idString = req.getParameter("idf");
        Long id = Long.parseLong(idString);
        String gradeStr = req.getParameter("grade");
        Double grade = Double.parseDouble(gradeStr);
        String corte = req.getParameter("corte");
        service.update(new GradesDto(id,grade,corte));
        System.out.println(service.gradesList());

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
            out.println("            <li>Id: " + id + "</li>");
            out.println("            <li>Grade: " + grade + "</li>");
            out.println("            <li>Corte: " + corte + "</li>");
            out.println("        </ul>");
            out.println("    </body>");
            out.println("</html>");
        }
    }
}
