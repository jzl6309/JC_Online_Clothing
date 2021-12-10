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
        name = "EditCatalog",
        urlPatterns = "/EditCatalog"
)

public class EditCatalogServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String options = req.getParameter("options");

        if (options.equals("add")) {
            CatalogService catalogService = CatalogService.getInstance();

            try {
                ArrayList<Item> catalog = catalogService.getCatalog();

                req.setAttribute("catalog", catalog);
                req.setAttribute("options", "add");
                RequestDispatcher view = req.getRequestDispatcher("EditCatalog.jsp");
                view.forward(req, resp);
            }
            catch (SQLException e) {

            }
        }
        if (options.equals("edit")) {
            CatalogService catalogService = CatalogService.getInstance();

            try {
                ArrayList<Item> catalog = catalogService.getCatalog();

                req.setAttribute("catalog", catalog);
                req.setAttribute("options", "edit");
                RequestDispatcher view = req.getRequestDispatcher("EditCatalog.jsp");
                view.forward(req, resp);
            }
            catch (SQLException e) {

            }
        }
        if (options.equals("addItem")) {
            String itemName = req.getParameter("itemName");
            String itemSex = req.getParameter("itemSex");
            String itemColor = req.getParameter("itemColor");
            String itemCost = req.getParameter("itemCost");
            String itemImage = req.getParameter("itemImage");

            EditCatalogService editCatalogService = new EditCatalogService(itemName, itemSex, itemColor, Double.parseDouble(itemCost), itemImage);

            editCatalogService.openConn();
            editCatalogService.addItem();
            editCatalogService.closeConn();

            CatalogService catalogService = CatalogService.getInstance();
            ArrayList<Item> catalog;

            try {
                catalog = catalogService.getCatalog();
                req.setAttribute("catalog", catalog);
            }
            catch (SQLException e) {

            }

            RequestDispatcher view = req.getRequestDispatcher("EditCatalog.jsp");
            view.forward(req, resp);
        }
        if (options.equals("editItem")) {
            int itemID = Integer.parseInt(req.getParameter("itemID"));
            String itemName = req.getParameter("itemName");
            String itemSex = req.getParameter("itemSex");
            String itemColor = req.getParameter("itemColor");
            String itemCost = req.getParameter("itemCost");
            String itemImage = req.getParameter("itemImage");

            EditCatalogService editCatalogService = new EditCatalogService(itemID, itemName, itemSex, itemColor, Double.parseDouble(itemCost), itemImage);

            editCatalogService.openConn();
            editCatalogService.editItem();
            editCatalogService.closeConn();

            CatalogService catalogService = CatalogService.getInstance();
            ArrayList<Item> catalog;

            try {
                catalog = catalogService.getCatalog();
                req.setAttribute("catalog", catalog);
            }
            catch (SQLException e) {

            }

            RequestDispatcher view = req.getRequestDispatcher("EditCatalog.jsp");
            view.forward(req, resp);
        }
    }
}
