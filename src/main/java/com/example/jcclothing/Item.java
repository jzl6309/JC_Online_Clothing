package com.example.jcclothing;

public class Item {

    private int itemID;
    private String itemName;
    private String itemColor;
    private char itemSize;
    private double itemPrice;
    private String imageFilename;

    public Item(int ID, String name, String color, char size, double price, String filename) {
        itemID = ID;
        itemName = name;
        itemColor = color;
        itemSize = size;
        itemPrice = price;
        imageFilename = filename;
    }

    public void setItemID(int ID){
        itemID = ID;
    }

    public void setItemName(String name){
        itemName = name;
    }

    public void setItemColor(String color){
        itemColor = color;
    }

    public void setItemSize(char size){
        itemSize = size;
    }

    public void setItemPrice(double price) {
        itemPrice = price;
    }

    public void setImageFilename(String filename){
        imageFilename = filename;
    }

    public int getItemID(){
        return itemID;
    }

    public String getItemName(){
        return  itemName;
    }

    public String getItemColor(){
        return  itemColor;
    }

    public char getItemSize(){
        return itemSize;
    }

    public double getItemPrice(){
        return itemPrice;
    }

    public String getImageFilename(){
        return imageFilename;
    }

}
