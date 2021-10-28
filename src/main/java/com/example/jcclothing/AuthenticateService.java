package com.example.jcclothing;

import java.sql.*;

public class AuthenticateService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/JCClothing";
    private static final String USER = "user";
    private static final String PW = "password";
    public static User user;
    public static boolean loggedIn;
    private String username;
    private String password;

    public AuthenticateService(String user, String pw) {
        username = user;
        password = pw;
    }

    public boolean authenticate() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PW);
        }
        catch (Exception e){
            System.out.println(e);
        }

        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("select * from Users;");

        while(result.next()) {
            if(result.getString("username").equals(username) &&
                    result.getString("password").equals(password)) {

                user = new User(result.getInt("id"),username, result.getString("email"),
                       result.getString("fname"), result.getString("lname"), result.getString("addr"),
                       result.getString("city"), result.getString("state"), result.getInt("zip"), result.getInt("type"));
                loggedIn = true;
                return true;
            }

        }


        return false;
    }

}
