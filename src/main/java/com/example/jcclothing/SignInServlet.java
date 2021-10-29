package com.example.jcclothing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "SignIn",
        urlPatterns = "/SignIn"
)

public class SignInServlet extends HttpServlet {

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {



        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        view.forward(req, resp);
    }

}
