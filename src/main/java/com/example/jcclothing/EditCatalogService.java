package com.example.jcclothing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditCatalogService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/JCClothing";
    private static final String USER = "user";
    private static final String PW = "password";
    private Connection conn = null;

    private int itemID;
    private String itemName;
    private String itemSex;
    private String itemColor;
    private double itemCost;
    private String itemImage;

    public EditCatalogService(String itemName, String itemSex, String itemColor, double itemCost, String itemImage) {
        this.itemName = itemName;
        this.itemSex = itemSex;
        this.itemColor = itemColor;
        this.itemCost = itemCost;
        this.itemImage = itemImage;
    }

    public EditCatalogService(int itemID, String itemName, String itemSex, String itemColor, double itemCost, String itemImage) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemSex = itemSex;
        this.itemColor = itemColor;
        this.itemCost = itemCost;
        this.itemImage = itemImage;
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

    public void addItem() {
        String insertStmt = "INSERT INTO Items (itemName, itemSex, itemColor, itemCost, itemImage)"
                + " VALUES (?,?,?,?,?);";
        try {
            PreparedStatement stmt = conn.prepareStatement(insertStmt);

            stmt.setString(1, itemName);
            stmt.setString(2, itemSex);
            stmt.setString(3, itemColor);
            stmt.setDouble(4, itemCost);
            stmt.setString(5, itemImage);

            stmt.execute();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editItem() {
        String updateStmt = "UPDATE Items SET itemName = ?, itemSex = ?, itemColor = ?, itemCost = ?, itemImage = ?"
                + "WHERE itemID = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(updateStmt);

            stmt.setString(1, itemName);
            stmt.setString(2, itemSex);
            stmt.setString(3, itemColor);
            stmt.setDouble(4, itemCost);
            stmt.setString(5, itemImage);
            stmt.setInt(6,itemID);

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
