package com.example.jcclothing;

import java.sql.*;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    public void getOrderShippingInfo(int orderNum) {
        Order order = Order.getInstance();

        try {
            String query = "SELECT * FROM Orders WHERE orderNum = ?;";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, orderNum);

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                order.setOrder(result.getString("fname"), result.getString("lname"), result.getString("addr"), result.getString("city"),
                        result.getString("state"), result.getString("zip"), null, 0);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateStatus(int orderNum, String status) {
        String updateStmt = "UPDATE Orders SET status = ? WHERE orderNum = ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(updateStmt);

            if (status.equals("Paid")) {
                stmt.setString(1, "In Process");
            }
            else {
                stmt.setString(1,"Shipped");
                String updateShippedStmt = "UPDATE Orders SET shippingDate = ? WHERE orderNum = ?;";
                PreparedStatement stmt2 = conn.prepareStatement(updateShippedStmt);

                DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
                Date date = new Date();
                format.format(date);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                stmt2.setDate(1, sqlDate);
                stmt2.setInt(2, orderNum);

                stmt2.execute();
            }

            stmt.setInt(2,orderNum);
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
