package com.example.jcclothing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "Checkout",
        urlPatterns = "/Checkout"
)

public class CheckoutServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Order order = Order.getInstance();
        ShoppingCart cart = ShoppingCart.getInstance();

        CheckoutService checkoutService = new CheckoutService(order, cart);

        checkoutService.openConn();
        checkoutService.processOrder();
        checkoutService.processOrderDetails();
        checkoutService.closeConn();

        req.setAttribute("fname", order.getFname());
        req.setAttribute("lname", order.getLname());
        req.setAttribute("addr", order.getAddr());
        req.setAttribute("city", order.getCity());
        req.setAttribute("state", order.getState());
        req.setAttribute("zip", order.getZip());
        req.setAttribute("CC", order.getCreditCard());
        req.setAttribute("confirm","confirm");
        RequestDispatcher view = req.getRequestDispatcher("Confirmation.jsp");
        view.forward(req, resp);
    }

}
