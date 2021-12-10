package com.example.jcclothing;
import java.util.ArrayList;

import java.sql.*;

public class UserList {


    private static final String DB_URL = "jdbc:mysql://localhost:3306/JCClothing";
    private static final String USER = "user";
    private static final String PW = "password";
    private Connection conn;

    public ArrayList<String> UserUsernames;
    public ArrayList<String> UserFNames;
    public ArrayList<String> UserLNames;
    public ArrayList<String> UserEmail;
    public ArrayList<String> UserAddr;
    public ArrayList<String> UserCity;
    public ArrayList<String> UserState;
    public ArrayList<String> UserZip;


    public UserList(){

        UserUsernames = new ArrayList<>();
        UserFNames = new ArrayList<>();
        UserLNames = new ArrayList<>();
        UserEmail = new ArrayList<>();
        UserAddr = new ArrayList<>();
        UserCity = new ArrayList<>();
        UserState = new ArrayList<>();
        UserZip = new ArrayList<>();
    }

    public UserList getUserNames() {

        UserList userList = new UserList();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JCClothing", USER, PW);
            Statement stmt = conn.createStatement();

            String selectStmt = "SELECT username, fname, lname, email, addr, city, state, zip FROM Users where type = 2;";

            ResultSet result = stmt.executeQuery(selectStmt);

            int i = 0;
            while (result.next()) {

                userList.UserUsernames.add(result.getString(1));
                userList.UserFNames.add(result.getString(2));
                userList.UserLNames.add(result.getString(3));
                userList.UserEmail.add(result.getString(4));
                userList.UserAddr.add(result.getString(5));
                userList.UserCity.add(result.getString(6));
                userList.UserState.add(result.getString(7));
                userList.UserZip.add(result.getString(8));
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
