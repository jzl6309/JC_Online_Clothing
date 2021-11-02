package com.example.jcclothing;

import java.sql.*;

public class ResetPasswordService {

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

    public boolean verifyUsername(String username) {

        boolean valid = false;
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT username,type FROM Users");

            while (result.next()) {
                String name = result.getString("username");
                int type = result.getInt("type");
                if (AuthenticateService.user.getType() <= type && name.equals(username)) valid = true;
            }
        }
        catch (SQLException e) {

        }
        return valid;
    }

    public void reset(String username) {
        String updateStmt = "UPDATE Users SET password = ? WHERE username = ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(updateStmt);

            stmt.setString(1, "temp123");
            stmt.setString(2, username);

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
