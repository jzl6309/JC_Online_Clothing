package com.example.jcclothing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "TrackOrder",
        urlPatterns = "/TrackOrder"
)

public class TrackOrderServlet extends HttpServlet {

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doPost(req, resp);
    }

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        TrackOrderService trackOrderService = new TrackOrderService();
        OrderHistory orderHistory = new OrderHistory();

        trackOrderService.openConn();

        if (req.getParameter("cancel") != null) {
            trackOrderService.cancel(Integer.parseInt(req.getParameter("cancel")));
        }
        if (AuthenticateService.loggedIn) {
            orderHistory = trackOrderService.getOrderHistory();

            req.setAttribute("orderHistory", orderHistory);
        }
        trackOrderService.closeConn();

        RequestDispatcher view = req.getRequestDispatcher("TrackOrder.jsp");
        view.forward(req, resp);
    }
}
