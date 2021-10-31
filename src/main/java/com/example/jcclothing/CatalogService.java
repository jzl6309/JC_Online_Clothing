package com.example.jcclothing;

import java.sql.*;
import java.util.ArrayList;

public class CatalogService {

    private final String DB_URL = "jdbc:mysql://localhost:3306/JCClothing";
    private final String USER = "user";
    private final String PW = "password";
    private ArrayList<Item> itemList;
    private ArrayList<Item> filteredList;
    private static CatalogService instance;

    private CatalogService(){}

    public static synchronized CatalogService getInstance() {

        if (instance == null) {
            instance = new CatalogService();
        }

        return instance;
    }

    public ArrayList<Item> getCatalog() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PW);
        }
        catch (Exception e){
            System.out.println(e);
        }

        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("select * from Items;");

        itemList = new ArrayList<>();
        while (result.next()) {
            itemList.add(new Item(result.getInt("itemID"),result.getString("itemName"),result.getString("itemSex").charAt(0), result.getString("itemColor"),
                    result.getDouble("itemCost"),result.getString("itemImage")));
        }


        conn.close();
        return itemList;
    }

    public Item getItem(int id){
        int i = 0;
        while (i < itemList.size()) {
            if (itemList.get(i).getItemID() == id) return itemList.get(i);
            i++;
        }
        return null;
    }

    public void setFilteredList(ArrayList<Item> list) { filteredList = list; }

    public ArrayList<Item> getFilteredList() {
        return filteredList;
    }
}
