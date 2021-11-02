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
        name = "SignUp",
        urlPatterns = "/SignUp"
)

public class SignUpServlet extends HttpServlet {

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String password2 = req.getParameter("confirm");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String addr = req.getParameter("addr");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String zip = req.getParameter("zip");
        int type = User.USER;
        boolean validUsername = false;
        boolean validPassword = false;
        boolean validEmail = false;

        SignUpService signUpService = null;
        String error = null;
        try {
            signUpService = new SignUpService(username, email, password, fname, lname, addr, city, state, zip, type);
        }
        catch (SQLException e) {
            error = "There was an issue.";
        }

        signUpService.openConn();
        try {
            validUsername = signUpService.verifyUsername();
        }
        catch (SQLException e){
            error = "There was an issue.";
        }

        try {
            validPassword = signUpService.verifyPasswordsMatch(password2);
        }
        catch (SQLException e) {
            error = "There was an issue.";
        }

        try {
            validEmail = signUpService.verifyEmail();
        }
        catch (SQLException e) {
            error = "There was an issue.";
        }

        if (validUsername && validPassword && validEmail) {
            signUpService.createNewUser();
            signUpService.closeConn();

            req.setAttribute("username", username);
            req.setAttribute("password", password);

            RequestDispatcher view = req.getRequestDispatcher("LoginServlet");
            view.forward(req, resp);
        }
        else {
            if (!validUsername) {
                error = "Invalid Username";
            }
            else if (!validEmail) {
                error = "Sorry. That email address is already in use.";
            }
            else if (!validPassword) {
                error = "Passwords Do Not Match";
            }

        }

        signUpService.closeConn();

        if (error != null) req.setAttribute("error", error);

        RequestDispatcher view = req.getRequestDispatcher("SignUp.jsp");
        view.forward(req, resp);
    }

}
