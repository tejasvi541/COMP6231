package com.comp6231.fruit_month_price_quantity.dto;

public class FruitPriceConversionDto {
  private long id;
  private String fruit;
  private String month;
  private double price;
  private int quantity;
  private double totalPrice;

  public FruitPriceConversionDto(long id, String fruit, String month, double price, int quantity,
      double totalPrice) {
    this.id = id;
    this.fruit = fruit;
    this.month = month;
    this.price = price;
    this.quantity = quantity;
    this.totalPrice = totalPrice;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setFruit(String fruit) {
    this.fruit = fruit;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public long getId() {
    return id;
  }

  public String getFruit() {
    return fruit;
  }

  public String getMonth() {
    return month;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getTotalPrice() {
    return totalPrice;
  }
}
