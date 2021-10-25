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
        name = "ItemDetails",
        urlPatterns = "/ItemDetails"
)

public class ItemDetailsServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CatalogService catalogService = CatalogService.getInstance();

        ArrayList<Item> catalog = null;
        try {
            catalog = catalogService.getCatalog();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int id = Integer.parseInt(req.getParameter("id"));
        int i = 0;
        while (catalog.get(i).getItemID() != id) {
            i++;
        }
        Item item = catalog.get(i);
        req.setAttribute("item", item);
        RequestDispatcher view = req.getRequestDispatcher("ItemDetails.jsp");
        view.forward(req, resp);
    }
}
