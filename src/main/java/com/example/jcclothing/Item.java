package com.example.jcclothing;

import java.util.Comparator;

public class Item {

    private int itemID;
    private String itemName;
    private String itemColor;
    private char itemSex;
    private double itemPrice;
    private String imageFilename;

    public Item(int ID, String name, char sex, String color, double price, String filename) {
        itemID = ID;
        itemName = name;
        itemSex = sex;
        itemColor = color;
        itemPrice = price;
        imageFilename = filename;
    }

    public void setItemID(int ID){
        itemID = ID;
    }

    public void setItemName(String name){
        itemName = name;
    }

    public void setItemSex(char sex) { itemSex = sex; }

    public void setItemColor(String color){
        itemColor = color;
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

    public char getItemSex() { return itemSex; }

    public String getItemColor(){
        return  itemColor;
    }

    public double getItemPrice(){
        return itemPrice;
    }

    public String getImageFilename(){
        return imageFilename;
    }

    public static class sortByPriceHighToLow implements Comparator<Item> {

        public int compare(Item i1, Item i2) {
            return i1.getItemPrice() < i2.getItemPrice() ? 1 : -1;
        }
    }

    public static class sortByPriceLowToHigh implements Comparator<Item> {

        public int compare(Item i1, Item i2) {
            return i1.getItemPrice() > i2.getItemPrice() ? 1 : -1;
        }
    }

    public static class sortByNameAZ implements Comparator<Item> {

        public int compare(Item i1, Item i2) {
            return i1.getItemName().compareTo(i2.getItemName());
        }
    }

    public static class sortByNameZA implements Comparator<Item> {

        public int compare(Item i1, Item i2) {
            return -(i1.getItemName().compareTo(i2.getItemName()));
        }
    }
}
