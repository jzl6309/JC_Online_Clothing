package com.example.jcclothing;

public class ShoppingCartItem {

    private Item item;
    private char size;
    private int quantity;

    public ShoppingCartItem (Item item, char size, int quantity) {
        this.item = item;
        this.size = size;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public char getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }
}
