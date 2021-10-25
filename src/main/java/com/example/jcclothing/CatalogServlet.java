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
        name = "Catalog",
        urlPatterns = "/Catalog"
)

public class CatalogServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CatalogService catalogService = CatalogService.getInstance();

        ArrayList<Item> catalog = null;
        try {
            catalog = catalogService.getCatalog();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String filter = req.getParameter("filter");
        ArrayList<Item> filteredCatalog = new ArrayList<>();

        if (filter != null) {
            if (filter.equals("mens")) {
                for (int i = 0; i < catalog.size(); i++) {
                    if (catalog.get(i).getItemSex() == 'M') filteredCatalog.add(catalog.get(i));
                }
            }
            else if (filter.equals("womens")) {
                for (int i = 0; i < catalog.size(); i++) {
                    if (catalog.get(i).getItemSex() == 'W') filteredCatalog.add(catalog.get(i));
                }
            }
            else if (filter.equals("search")) {
                String[] searchStr = req.getParameter("searchBox").split(" ");
                ArrayList<Item> matchingTypeArr = new ArrayList<>();
                ArrayList<Item> matchingColorArr = new ArrayList<>();
                for (int i = 0; i < catalog.size(); i++) {
                    for (int j = 0; j < searchStr.length; j++) {
                        if (catalog.get(i).getItemName().toLowerCase().contains(searchStr[j].toLowerCase())  &&
                            !matchingTypeArr.contains(catalog.get(i))) matchingTypeArr.add(catalog.get(i));
                    }
                }
                for (int i = 0; i < catalog.size(); i++) {
                    for (int j = 0; j < searchStr.length; j++) {
                        if (catalog.get(i).getItemColor().toLowerCase().contains(searchStr[j].toLowerCase())  &&
                            !matchingColorArr.contains(catalog.get(i))) matchingColorArr.add(catalog.get(i));
                    }
                }
                if (matchingColorArr.size() > 0 && matchingTypeArr.size() > 0) {
                    for (int i = 0; i < matchingColorArr.size(); i++){
                        for (int j = 0; j < matchingTypeArr.size(); j++){
                            if (matchingColorArr.get(i).getItemID() == matchingTypeArr.get(j).getItemID())
                                filteredCatalog.add(matchingColorArr.get(i));
                        }
                    }
                }
                else {
                    filteredCatalog = matchingColorArr.size() > matchingTypeArr.size() ? matchingColorArr : matchingTypeArr;
                }
            }
            req.setAttribute("catalog",filteredCatalog);
        }
        else {
            req.setAttribute("catalog", catalog);
        }

        RequestDispatcher view = req.getRequestDispatcher("Catalog.jsp");
        view.forward(req, resp);
    }
}
