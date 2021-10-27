package com.example.jcclothing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet (
        name = "ShoppingCart",
        urlPatterns = "/ShoppingCart"
)

public class ShoppingCartServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("item") != null) {
            CatalogService catalogService = CatalogService.getInstance();

            Item item = catalogService.getItem(Integer.parseInt(req.getParameter("item")));
            char size = req.getParameter("size").charAt(0);
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            ShoppingCartItem shItem = new ShoppingCartItem(item, size, quantity);

            ShoppingCart cart = ShoppingCart.getInstance();
            cart.add(shItem);

            req.setAttribute("item", item);
            RequestDispatcher view = req.getRequestDispatcher("ItemDetails.jsp");
            view.forward(req, resp);
        }
        else if (req.getParameter("removeItem") != null) {
            ShoppingCart cart = ShoppingCart.getInstance();

            cart.remove(Integer.parseInt(req.getParameter("removeItem")));

            RequestDispatcher view = req.getRequestDispatcher("ShoppingCart.jsp");
            view.forward(req, resp);
        }

    }
}
