package com.example.jcclothing;

public class User {
    public static final int ADMIN = 0;
    public static final int STAFF = 1;
    public static final int USER  = 2;

    private int ID;
    private String user;
    private String email;
    private String fname;
    private String lname;
    private String addr;
    private String city;
    private String state;
    private int zip;
    private int type;

    public User(int id, String user, String email, String fname, String lname, String addr, String city, String state, int zip, int type ){
        ID = id;
        this.user = user;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.addr = addr;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.type = type;
    }

    public int getID(){
        return ID;
    }

    public String getUser(){
        return user;
    }

    public String getEmail(){
        return email;
    }

    public String getFname() { return fname; }

    public String getLname() { return lname; }

    public String getAddr() { return addr; }

    public String getCity() { return city; }

    public String getState() { return state; }

    public int getZip() { return zip; }

    public int getType() { return type; }
}
