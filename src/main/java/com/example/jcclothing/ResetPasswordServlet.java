package com.example.jcclothing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "ResetPassword",
        urlPatterns = "/ResetPassword"
)

public class ResetPasswordServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        ResetPasswordService reset = new ResetPasswordService();
        reset.openConn();

        if (reset.verifyUsername(req.getParameter("username"))) {
            reset.reset(req.getParameter("username"));
            req.setAttribute("username",req.getParameter("username"));
        }
        else {
            req.setAttribute("error","Please enter a valid username.");
        }
        reset.closeConn();

        RequestDispatcher view = req.getRequestDispatcher("ResetUserPassword.jsp");
        view.forward(req, resp);
    }

}
