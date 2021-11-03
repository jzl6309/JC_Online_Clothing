package com.example.jcclothing;

import java.sql.*;

public class CheckoutService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/JCClothing";
    private static final String USER = "user";
    private static final String PW = "password";
    private static final int GUEST = -1;
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
        String insertStmt = insertStmt = "INSERT INTO Orders (userID, fname, lname, addr, city, state, zip, total, creditCard, status) "
                    + "values (?,?,?,?,?,?,?,?,?,?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(insertStmt);

            int userID;
            if (AuthenticateService.user != null) {
                userID = AuthenticateService.user.getID();
            }
            else {
                userID = GUEST;
            }

            stmt.setInt(1,userID);
            stmt.setString(2, order.getFname());
            stmt.setString(3, order.getLname());
            stmt.setString(4, order.getAddr());
            stmt.setString(5, order.getCity());
            stmt.setString(6, order.getState());
            stmt.setString(7, order.getZip());
            stmt.setDouble(8, order.getTotalPrice());
            stmt.setString(9, Order.getInstance().getCreditCard());
            stmt.setString(10, "Paid");

            stmt.execute();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void processOrderDetails() {

        Statement stmt = null;
        try {
            stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("SELECT max(orderNum) as max FROM Orders");

            int orderNum = -1;
            while (resultSet.next()) {
                orderNum = resultSet.getInt("max");
            }

            for (int i = 0; i < cart.size(); i++) {

                String insertStmt = "INSERT INTO OrderDetails (orderNum, itemID, size, quantity, price)"
                        + " values (?,?,?,?,?)";

                PreparedStatement preparedStatement = conn.prepareStatement(insertStmt);

                preparedStatement.setInt(1, orderNum);
                preparedStatement.setInt(2, cart.get(i).getItem().getItemID());
                preparedStatement.setString(3, Character.toString(cart.get(i).getSize()));
                preparedStatement.setInt(4, cart.get(i).getQuantity());
                preparedStatement.setDouble(5, cart.get(i).getItem().getItemPrice());

                preparedStatement.execute();
            }
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
