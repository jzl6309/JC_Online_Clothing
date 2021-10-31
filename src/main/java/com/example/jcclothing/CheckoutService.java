package com.example.jcclothing;

import java.sql.*;
import java.time.LocalDate;

public class CheckoutService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/JCClothing";
    private static final String USER = "user";
    private static final String PW = "password";
    private Connection conn;

    private Order order;
    private ShoppingCart cart;

    public CheckoutService (Order order, ShoppingCart cart) {
       this.order = order;
       this.cart = cart;
    }

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

    public void processOrder() {
        String insertStmt = null;

        insertStmt = "INSERT INTO Orders (userID, fname, lname, addr, city, state, zip, total, orderDate) "
                    + "values (?,?,?,?,?,?,?,?,?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(insertStmt);

            int userID;
            if (AuthenticateService.user != null) {
                userID = AuthenticateService.user.getID();
            }
            else {
                userID = -1;
            }

            stmt.setInt(1,userID);
            stmt.setString(2, order.getFname());
            stmt.setString(3, order.getLname());
            stmt.setString(4, order.getAddr());
            stmt.setString(5, order.getCity());
            stmt.setString(6, order.getState());
            stmt.setInt(7, order.getZip());
            stmt.setDouble(8, order.getTotalPrice());
            stmt.setDate(9, Date.valueOf(LocalDate.now()));

            stmt.execute();
        }
        catch (SQLException e) {

        }
    }

    public void processOrderDetails() {

        Statement stmt = null;
        try {
            stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("SELECT max(orderNum) FROM Orders");


            while (resultSet.next()) {
                int orderNum = resultSet.getInt("orderNum");
            }

            String insertStmt = "INSERT INTO OrderDetails (orderNum, itemID, size, quantity, price)"
                    + "(?,?,?,?,?)";

        }
        catch (SQLException e) {

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
