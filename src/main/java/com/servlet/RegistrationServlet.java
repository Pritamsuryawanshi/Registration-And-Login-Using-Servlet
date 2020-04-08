package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/Register"},
        initParams = {
                @WebInitParam(name = "users", value = "^[A-Z]{1}[a-z]{3,}$"),
                @WebInitParam(name = "passwords", value = "((?=.*\\d)(?=.*[A-Z])(?=.*[@#$%]).{8,15})")
        }
)
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("userName");
        String pwd = request.getParameter("paswd");

        String userID = getServletConfig().getInitParameter("users");
        String password = getServletConfig().getInitParameter("passwords");
        if (user.matches(userID) && pwd.matches(password)) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/RegistrationSuccess.jsp").forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Registration.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Please follow username and password standards to register,</font>");
            rd.include(request, response);
        }
    }
}
