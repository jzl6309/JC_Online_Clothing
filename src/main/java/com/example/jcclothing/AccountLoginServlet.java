package com.example.jcclothing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "AccountLoginServlet",
        urlPatterns = "/AccountLoginServlet"
)

public class AccountLoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (AuthenticateService.loggedIn){
            RequestDispatcher view = req.getRequestDispatcher("Account.jsp");
            view.forward(req,resp);
        }
        else{
            RequestDispatcher view = req.getRequestDispatcher("Login.jsp");
            view.forward(req,resp);
        }
    }

}
