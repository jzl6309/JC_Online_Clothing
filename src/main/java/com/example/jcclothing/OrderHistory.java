package com.example.jcclothing;

import java.util.ArrayList;
import java.util.Date;

public class OrderHistory {

    private ArrayList<TrackedOrder> orderHistory;

    public OrderHistory() {
        orderHistory = new ArrayList<>();
    }

    public void add(TrackedOrder order) { orderHistory.add(order); }

    public TrackedOrder get(int i) { return orderHistory.get(i); }

    public int size() { return orderHistory.size(); }

    public class TrackedOrder {

        private int orderNum;
        private int userID;
        private Date orderDate;
        private double totalPrice;
        private String status;
        private Date shippingDate;

        public TrackedOrder (int orderNum, int userID, Date orderDate, double totalPrice, String status, Date shippingDate) {
            this.orderNum = orderNum;
            this.userID = userID;
            this.orderDate = orderDate;
            this.totalPrice = totalPrice;
            this.status = status;
            this.shippingDate = shippingDate;
        }

        public int getOrderNum() { return orderNum; }

        public int getUserID() { return userID; }

        public Date getOrderDate() { return orderDate; }

        public double getTotalPrice() { return totalPrice; }

        public String getStatus() { return status; }

        public Date getShippingDate() { return shippingDate; }
    }
}
