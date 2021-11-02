package com.example.jcclothing;

import java.sql.*;
import java.util.ArrayList;

public class TrackOrderService {
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

    public OrderHistory getOrderHistory(){

        OrderHistory orderHistory = null;
        try {
            int id = AuthenticateService.user.getID();

            String query = "SELECT * FROM Orders WHERE userID = ?;";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();

            orderHistory = new OrderHistory();

            while (result.next()) {
                OrderHistory.TrackedOrder orderItem = orderHistory.new TrackedOrder(result.getInt("orderNum"),
                        result.getInt("userID"), result.getDate("orderDate"), result.getDouble("total"), result.getString("status"), result.getDate("shippingDate"));

                orderHistory.add(orderItem);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return orderHistory;
    }

    public void cancel(int i) {
        String updateStmt = "UPDATE Orders SET status = ? WHERE orderNum = ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(updateStmt);

            stmt.setString(1, "Cancelled");
            stmt.setInt(2, i);

            stmt.execute();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void closeConn() {
        try {
            conn.close();
        }
        catch (SQLException e) {

        }
    }
}
