package com.example.jcclothing;

import java.sql.*;

public class UserList {


    private static final String DB_URL = "jdbc:mysql://localhost:3306/JCClothing";
    private static final String USER = "user";
    private static final String PW = "password";
    private Connection conn;

    public String[] UserUsernames;
    public String[] UserFNames;
    public String[] UserLNames;

    public String[] getUserFNames() {
        return UserFNames;
    }

    public String[] getUserLNames() {
        return UserLNames;
    }



    public UserList(){

        UserUsernames = new String[1];
        UserFNames = new String[1];
        UserLNames = new String[1];

    }

    public UserList getUserNames() {

        UserList userList = new UserList();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JCClothing", USER, PW);
            Statement stmt = conn.createStatement();

            String selectStmt = "SELECT username, fname, lname FROM Users where type = 2;";

            ResultSet result = stmt.executeQuery(selectStmt);

            userList.UserUsernames = new String[50];
            userList.UserFNames = new String[50];
            userList.UserLNames = new String[50];

            int i = 0;
            while (result.next()) {

                userList.UserUsernames[i] = (result.getString(1));
                userList.UserFNames[i] = (result.getString(2));
                userList.UserLNames[i] = (result.getString(3));

                i++;
            }

        }
        catch (SQLException e){
            System.out.printf("ERROR");
        }

        try {
            conn.close();
        }
        catch (SQLException e) {
            System.out.println(e);
        }


        return userList;
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

    public void closeConn() {
        try {
            conn.close();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }

}
