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
            ArrayList<OrderDetails> orderDetails;

            orderDetailsService.openConn();
            orderDetails = orderDetailsService.getOrderDetails(Integer.parseInt(req.getParameter("order")));
            orderDetailsService.closeConn();

            req.setAttribute("orderDetails", orderDetails);
            RequestDispatcher view = req.getRequestDispatcher("OrderDetails.jsp");
            view.forward(req, resp);
        }
        else if(req.getParameter("orderNum") != null) {
            int orderNum = Integer.parseInt(req.getParameter("orderNum"));

            OrderDetailsService orderDetailsService = new OrderDetailsService();

            orderDetailsService.openConn();
            orderDetailsService.getOrderShippingInfo(orderNum);
            orderDetailsService.closeConn();

            TrackOrderService trackOrderService = new TrackOrderService();
            OrderHistory orderHistory;

            trackOrderService.openConn();
            orderHistory = trackOrderService.getAllOrderHistory();
            trackOrderService.closeConn();

            req.setAttribute("orderNum", orderNum);
            req.setAttribute("orderHistory",orderHistory);
            req.setAttribute("shippingInfo", "shippingInfo");
            RequestDispatcher view = req.getRequestDispatcher("OrderProcessing.jsp");
            view.forward(req, resp);
        }
        else if(req.getParameter("update") != null) {
            int orderNum = Integer.parseInt(req.getParameter("update"));
            String status = req.getParameter("status");

            OrderDetailsService orderDetailsService = new OrderDetailsService();

            orderDetailsService.openConn();
            orderDetailsService.updateStatus(orderNum, status);
            orderDetailsService.closeConn();

            TrackOrderService trackOrderService = new TrackOrderService();
            OrderHistory orderHistory;

            trackOrderService.openConn();
            orderHistory = trackOrderService.getAllOrderHistory();
            trackOrderService.closeConn();

            req.setAttribute("orderNum", orderNum);
            req.setAttribute("orderHistory",orderHistory);
            RequestDispatcher view = req.getRequestDispatcher("OrderProcessing.jsp");
            view.forward(req, resp);

        }

    }
}
