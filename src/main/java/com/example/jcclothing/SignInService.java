package com.example.jcclothing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SignInService {
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
    Connection conn = null;

    public SignInService (String username, String email, String password, String fname, String lname, String addr,
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

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openConn() {

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PW);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean verifyUsername() {



        return true;
    }

}
