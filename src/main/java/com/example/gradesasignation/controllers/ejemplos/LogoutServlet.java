package com.example.gradesasignation.controllers.ejemplos;

import com.example.gradesasignation.annotations.Login;
import com.example.gradesasignation.service.LoginService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Inject
    @Login
    LoginService auth;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        Optional<String> username = auth.getUsername(req);
        if (username.isPresent()) {
            Cookie usernameCookie = new Cookie("username", "");
            usernameCookie.setMaxAge(0);
            resp.addCookie(usernameCookie);
        }
        resp.sendRedirect(req.getContextPath() + "/login.html");
    }

}
