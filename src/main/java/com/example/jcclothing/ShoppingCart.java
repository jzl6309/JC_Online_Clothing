package com.example.jcclothing;

import java.util.ArrayList;

public class ShoppingCart {

    private static ShoppingCart instance;
    private ArrayList<ShoppingCartItem> shoppingCart;

    public ShoppingCart(){
        shoppingCart = new ArrayList<>();
    }

    public static synchronized ShoppingCart getInstance() {

        if (instance == null) {
            instance = new ShoppingCart();
        }

        return instance;
    }

    public void add(ShoppingCartItem item) {
        shoppingCart.add(item);
    }

    public void remove(int id){
        int i = 0;
        while (i < shoppingCart.size()) {
            if (shoppingCart.get(i).getItem().getItemID() == id) {
                shoppingCart.remove(i);
                return;
            }
            i++;
        }
    }

    public ArrayList<ShoppingCartItem> getShoppingCart() {
        return shoppingCart;
    }

    public int size(){
        return shoppingCart.size();
    }

    public ShoppingCartItem get(int i) {
        return shoppingCart.get(i);
    }

}
