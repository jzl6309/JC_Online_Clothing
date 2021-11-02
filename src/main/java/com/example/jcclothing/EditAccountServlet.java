package com.example.jcclothing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "EditAccount",
        urlPatterns = "/EditAccount"
)

public class EditAccountServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        EditAccountService editAccountService = null;
        if(req.getParameter("password") == "" && req.getParameter("confirm") == "") {
            editAccountService = new EditAccountService(req.getParameter("email"), req.getParameter("addr"), req.getParameter("city"),
                    req.getParameter("state"), req.getParameter("zip"));

            editAccountService.openConn();
            editAccountService.updateUser();
            editAccountService.closeConn();

        }
        else if(req.getParameter("password") != ""){
            if(req.getParameter("password").equals(req.getParameter("confirm"))) {
                editAccountService = new EditAccountService(req.getParameter("email"), req.getParameter("addr"), req.getParameter("city"),
                        req.getParameter("state"), req.getParameter("zip"), req.getParameter("password"));

                editAccountService.openConn();
                editAccountService.updateUser();
                editAccountService.updatePassword();
                editAccountService.closeConn();
            }
            else {
                req.setAttribute("error","Your passwords do not match. Please try again.");
                RequestDispatcher view = req.getRequestDispatcher("EditAccount.jsp");
                view.forward(req, resp);
            }
        }

        RequestDispatcher view = req.getRequestDispatcher("Account.jsp");
        view.forward(req, resp);

    }
}
