package com.example.jcclothing;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class StaffList {


    private static final String DB_URL = "jdbc:mysql://localhost:3306/JCClothing";
    private static final String USER = "user";
    private static final String PW = "password";
    private Connection conn;

    public ArrayList<Integer> StaffID;
    public ArrayList<String> StaffUsernames;
    public ArrayList<String> StaffFnameArray;
    public ArrayList<String> StaffLnameArray;
    public ArrayList<String> StaffEmail;
    public ArrayList<String> StaffAddr;
    public ArrayList<String> StaffCity;
    public ArrayList<String> StaffState;
    public ArrayList<String> StaffZip;

    public StaffList(){
        StaffID = new ArrayList<>();
        StaffUsernames = new ArrayList<>();
        StaffFnameArray = new ArrayList<>();
        StaffLnameArray = new ArrayList<>();
        StaffEmail = new ArrayList<>();
        StaffAddr = new ArrayList<>();
        StaffCity = new ArrayList<>();
        StaffState = new ArrayList<>();
        StaffZip = new ArrayList<>();
    }

    public StaffList getStaffNames() {

        StaffList staffList = new StaffList();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JCClothing", USER, PW);
            Statement stmt = conn.createStatement();

            String selectStmt = "SELECT username, fname, lname, email, addr, city, state, zip, id FROM Users where type = 1;";

            ResultSet result = stmt.executeQuery(selectStmt);


            while (result.next()) {

                staffList.StaffUsernames.add(result.getString(1));
                staffList.StaffFnameArray.add(result.getString(2));
                staffList.StaffLnameArray.add(result.getString(3));
                staffList.StaffEmail.add(result.getString(4));
                staffList.StaffAddr.add(result.getString(5));
                staffList.StaffCity.add(result.getString(6));
                staffList.StaffState.add(result.getString(7));
                staffList.StaffZip.add(result.getString(8));
                staffList.StaffID.add(result.getInt(9));
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
