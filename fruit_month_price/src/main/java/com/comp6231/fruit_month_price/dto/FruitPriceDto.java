package com.comp6231.fruit_month_price.dto;

public class FruitPriceDto {

    private long id;
    private String fruit;
    private String month;
    private double price;

    public FruitPriceDto(long id, String fruit, String month, double price) {
        this.id = id;
        this.fruit = fruit;
        this.month = month;
        this.price = price;
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
