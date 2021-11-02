package com.example.jcclothing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditAccountService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/JCClothing";
    private static final String USER = "user";
    private static final String PW = "password";

    private Connection conn = null;
    private String email;
    private String addr;
    private String city;
    private String state;
    private String zip;
    private String password;

    public EditAccountService(String email, String addr, String city, String state, String zip) {
        this.email = email;
        this.addr = addr;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public EditAccountService(String email, String addr, String city, String state, String zip, String password) {
        this.email = email;
        this.addr = addr;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.password = password;
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

    public void updateUser() {
        User user = AuthenticateService.user;

        user.setEmail(email);
        user.setAddr(addr);
        user.setCity(city);
        user.setState(state);
        user.setZip(zip);

        int id = AuthenticateService.user.getID();
        String updateStmt = "UPDATE Users SET email = ?, addr = ?, city = ?, state = ?, zip = ? WHERE id = ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(updateStmt);

            stmt.setString(1, email);
            stmt.setString(2, addr);
            stmt.setString(3, city);
            stmt.setString(4, state);
            stmt.setString(5, zip);
            stmt.setInt(6, id);

            stmt.execute();
        }
        catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void updatePassword() {
        int id = AuthenticateService.user.getID();
        String updateStmt = "UPDATE Users SET password = ? WHERE id = ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(updateStmt);

            stmt.setString(1,password);
            stmt.setInt(2, id);

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
