package com.example.jcclothing;

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
        Order order = (Order) req.getAttribute("order");
        ShoppingCart cart = ShoppingCart.getInstance();

        CheckoutService checkoutService = new CheckoutService(order, cart);

        checkoutService.openConn();
        checkoutService.processOrder();

        checkoutService.closeConn();

    }

}
