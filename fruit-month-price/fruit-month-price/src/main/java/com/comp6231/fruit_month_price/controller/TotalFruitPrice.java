package com.comp6231.fruit_month_price.controller;

public class TotalFruitPrice {

    private String fruit;
    private String month;
    private int quantity;
    private double totalPrice;

    public TotalFruitPrice(String fruit, String month, int quantity, double totalPrice) {
        this.fruit = fruit;
        this.month = month;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters and setters
    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
