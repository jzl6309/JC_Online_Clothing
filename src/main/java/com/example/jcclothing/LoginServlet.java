package com.example.jcclothing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(
        name = "LoginServlet",
        urlPatterns = "/LoginServlet"
)

public class LoginServlet extends HttpServlet{

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AuthenticateService authServ = new AuthenticateService(req.getParameter("username"),req.getParameter("password"));

        boolean auth = false;
        try {
            auth = authServ.authenticate();
            boolean log = AuthenticateService.loggedIn;
        }
        catch (SQLException e){

        }
        RequestDispatcher view = null;
        if (auth) {
            view = req.getRequestDispatcher("Catalog.jsp");
        }
        else {
            view = req.getRequestDispatcher("Login.jsp");

        }
        view.forward(req, resp);

    }
}
