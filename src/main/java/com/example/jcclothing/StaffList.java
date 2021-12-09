package com.example.jcclothing;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class StaffList {


    private static final String DB_URL = "jdbc:mysql://localhost:3306/JCClothing";
    private static final String USER = "user";
    private static final String PW = "password";
    private Connection conn;

    public String[] StaffUsernames;
    public String[] StaffFnameArray;
    public String[] StaffLnameArray;

    public String[] getStaffFnameArray() {
        return StaffFnameArray;
    }

    public String[] getStaffLnameArray() {
        return StaffLnameArray;
    }



    public StaffList(){

        StaffUsernames = new String[1];
        StaffFnameArray = new String[1];
        StaffLnameArray = new String[1];

    }

    public StaffList getStaffNames() {

        StaffList staffList = new StaffList();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JCClothing", USER, PW);
            Statement stmt = conn.createStatement();

            String selectStmt = "SELECT username, fname, lname FROM Users where type = 1;";

            ResultSet result = stmt.executeQuery(selectStmt);

            staffList.StaffUsernames = new String[50];
            staffList.StaffFnameArray = new String[50];
            staffList.StaffLnameArray = new String[50];

            int i = 0;
            while (result.next()) {

                staffList.StaffUsernames[i] = (result.getString(1));
                staffList.StaffFnameArray[i] = (result.getString(2));
                staffList.StaffLnameArray[i] = (result.getString(3));

                i++;
            }

            try {
                conn.close();
            }
            catch (SQLException e) {
                System.out.println(e);
            }

        }
        catch (SQLException e){
            System.out.printf("ERROR");
        }

        return staffList;
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
