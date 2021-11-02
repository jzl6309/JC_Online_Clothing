package com.example.jcclothing;

public class OrderDetails {

    private int orderNum;
    private int itemID;
    private String itemImage;
    private String itemName;
    private String size;
    private String itemColor;
    private int quantity;
    private double price;

    public OrderDetails(int orderNum, int itemID, String itemImage, String itemName, String size, String itemColor, int quantity, double price) {
        this.orderNum = orderNum;
        this.itemID = itemID;
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.size = size;
        this.itemColor = itemColor;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderNum() { return orderNum; }

    public int getItemID() { return itemID; }

    public String getItemImage() { return itemImage; }

    public String getItemName() { return itemName; }

    public String getSize() { return size; }

    public String getItemColor() { return itemColor; }

    public int getQuantity() { return quantity; }

    public double getPrice() { return price; }
}
