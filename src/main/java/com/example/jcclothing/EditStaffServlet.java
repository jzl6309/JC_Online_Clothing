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
        name = "EditStaff",
        urlPatterns = "/EditStaff"
)

public class EditStaffServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String options = req.getParameter("options");

        if (options.equals("add")) {
            req.setAttribute("options", "add");
            RequestDispatcher view = req.getRequestDispatcher("ListStaff.jsp");
            view.forward(req, resp);
        }
        if (options.equals("addStaff")) {
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String password = "temp123";
            String fname = req.getParameter("fname");
            String lname = req.getParameter("lname");
            String addr = req.getParameter("addr");
            String city = req.getParameter("city");
            String state = req.getParameter("state");
            String zip = req.getParameter("zip");
            int type = User.STAFF;

            SignUpService newStaff = null;
            try {
                newStaff = new SignUpService(username, email, password, fname, lname, addr, city, state, zip, type);
            }
            catch (SQLException e) {

            }

            newStaff.openConn();
            newStaff.createNewUser();
            newStaff.closeConn();

            RequestDispatcher view = req.getRequestDispatcher("ListStaff.jsp");
            view.forward(req, resp);
        }
        if (options.equals("remove")) {
            req.setAttribute("options", "remove");
            RequestDispatcher view = req.getRequestDispatcher("ListStaff.jsp");
            view.forward(req, resp);
        }
        if (options.equals("removeStaff")) {
            int ID = Integer.parseInt(req.getParameter("ID"));

            SignUpService removeStaff = new SignUpService();

            removeStaff.openConn();
            removeStaff.removeStaff(ID);
            removeStaff.closeConn();

            RequestDispatcher view = req.getRequestDispatcher("ListStaff.jsp");
            view.forward(req, resp);
        }
    }
}
