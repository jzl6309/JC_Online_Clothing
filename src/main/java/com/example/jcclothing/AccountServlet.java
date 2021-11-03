package com.example.jcclothing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(
        name = "AccountServlet",
        urlPatterns = "/AccountServlet"
)

public class AccountServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String option = req.getParameter("options");

        if (option.equals("logout")) {
            AuthenticateService.logout();
        }
        else if (option.equals("updateAddress")) {
            RequestDispatcher view = req.getRequestDispatcher("EditAccount.jsp");
            view.forward(req, resp);
        }
        else if (option.equals("catalog")) {
            CatalogService catalogService = CatalogService.getInstance();

            try {
                ArrayList<Item> catalog = catalogService.getCatalog();

                req.setAttribute("catalog", catalog);
                RequestDispatcher view = req.getRequestDispatcher("EditCatalog.jsp");
                view.forward(req, resp);
            }
            catch (SQLException e) {

            }
        }
        else if (option.equals("orders")) {
            TrackOrderService trackOrderService = new TrackOrderService();
            OrderHistory orderHistory;

            trackOrderService.openConn();
            orderHistory = trackOrderService.getAllOrderHistory();
            trackOrderService.closeConn();

            req.setAttribute("orderHistory",orderHistory);
            RequestDispatcher view = req.getRequestDispatcher("OrderProcessing.jsp");
            view.forward(req, resp);
        }

        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        view.forward(req, resp);
    }
}
