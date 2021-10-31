package com.example.jcclothing;

public class Order {

    private static Order instance;
    private int userID;
    private String fname;
    private String lname;
    private String addr;
    private String city;
    private String state;
    private int zip;
    private double totalPrice;
    private String creditCard;
    private ShoppingCart cart;

    public Order() {}

    public static synchronized Order getInstance() {

        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }

    public void setOrder(String fname, String lname, String addr, String city, String state, int zip, String creditCard, double totalPrice) {

        if (AuthenticateService.user != null) userID = AuthenticateService.user.getID();
        this.fname = fname;
        this.lname = lname;
        this.addr = addr;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.creditCard = creditCard;
        this.totalPrice = totalPrice;
        cart = ShoppingCart.getInstance();
    }

    public static void empty(){
        instance = null;
    }

    public int getUserID() { return userID; }

    public String getFname() { return fname; }

    public String getLname() { return lname; }

    public String getAddr() { return addr; }

    public String getCity() { return city; }

    public String getState() { return state; }

    public int getZip() { return zip; }

    public double getTotalPrice() { return totalPrice; }

    public String getCreditCard() { return creditCard; }
}
