package com.example.jcclothing;

import java.sql.*;
import java.util.ArrayList;

public class OrderDetailsService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/JCClothing";
    private static final String USER = "user";
    private static final String PW = "password";
    private Connection conn;

    public void openConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PW);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<OrderDetails> getOrderDetails(int orderNum) {
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();

        try {
            String query = "SELECT * FROM OrderDetails,Items WHERE orderNum = ? AND Items.itemID = OrderDetails.itemID;";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, orderNum);

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                orderDetails.add(new OrderDetails(orderNum, result.getInt("itemID"), result.getString("itemImage"), result.getString("itemName"),
                        result.getString("size"), result.getString("itemColor"), result.getInt("quantity"), result.getDouble("price")));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return orderDetails;
    }

    public void closeConn() {
        try {
            conn.close();
        }
        catch (SQLException e) {

        }
    }
}
