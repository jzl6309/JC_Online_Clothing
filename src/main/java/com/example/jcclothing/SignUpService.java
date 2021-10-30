package com.example.jcclothing;

import java.sql.*;

public class SignUpService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/JCClothing";
    private static final String USER = "user";
    private static final String PW = "password";

    private String username;
    private String email;
    private String password;
    private String fname;
    private String lname;
    private String addr;
    private String city;
    private String state;
    private int zip;
    private int type;
    private Connection conn = null;
    private boolean validSignUp =true;
    private boolean validEmail = true;

    public SignUpService(String username, String email, String password, String fname, String lname, String addr,
                         String city, String state, int zip, int type) throws SQLException {

        this.username = username;
        this.email = email;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.addr = addr;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.type = type;

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

    public boolean verifyUsername() throws SQLException {

        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT username FROM Users");

        while(result.next()) {
            String name = result.getString("username");
            if (name.equals(username)) validSignUp = false;
        }

        return validSignUp;
    }

    public boolean verifyPasswordsMatch(String password) throws SQLException {

        return this.password.equals(password);
    }

    public boolean verifyEmail() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT email FROM Users");

        while(result.next()) {
            String name = result.getString("email");
            if (name.equals(email)) validEmail = false;
        }

        return validEmail;
    }

    public void createNewUser() {
        String insertStmt = "INSERT INTO Users ( username, email, password, fname, lname, addr, city, state, zip, type)"
                + " values (?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement stmt = conn.prepareStatement(insertStmt);

            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, fname);
            stmt.setString(5, lname);
            stmt.setString(6, addr);
            stmt.setString(7, city);
            stmt.setString(8, state);
            stmt.setInt(9, zip);
            stmt.setInt(10, type);

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
