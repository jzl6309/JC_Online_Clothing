package com.example.jcclothing;

public class User {
    public static final int ADMIN = 0;
    public static final int STAFF = 1;
    public static final int USER  = 2;

    private int ID;
    private String user;
    private String email;
    private int type;

    public User(int id, String user, String email, int type ){
        ID = id;
        this.user = user;
        this.email = email;
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
}
