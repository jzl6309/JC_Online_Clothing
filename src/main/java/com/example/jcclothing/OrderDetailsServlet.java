package com.example.jcclothing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(
        name = "OrderDetails",
        urlPatterns = "/OrderDetails"
)

public class OrderDetailsServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        if(req.getParameter("order") != null) {
            OrderDetailsService orderDetailsService = new OrderDetailsService();
            ArrayList<OrderDetails> orderDetails = new ArrayList<>();

            orderDetailsService.openConn();
            orderDetails = orderDetailsService.getOrderDetails(Integer.parseInt(req.getParameter("order")));
            orderDetailsService.closeConn();

            req.setAttribute("orderDetails", orderDetails);
            RequestDispatcher view = req.getRequestDispatcher("OrderDetails.jsp");
            view.forward(req, resp);
        }
    }
}
