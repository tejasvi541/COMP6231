package com.comp6231.fruit_month_price.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Transient;

@Entity
public class FruitPrice {

    @Id
    private long id;
    @Column
    private String fruit;
    @Column
    private double jan;
    @Column
    private double feb;
    @Column
    private double mar;
    @Column
    private double apr;
    @Column
    private double may;
    @Column
    private double jun;
    @Column
    private double jul;
    @Column
    private double aug;
    @Column
    private double sep;
    @Column
    private double oct;
    @Column
    private double nov;
    @Column
    private double dec;

    // Price for the specific month, not stored in DB
    @Transient
    private double price;

    public FruitPrice() {
    }

    public FruitPrice(long id, String fruit, double jan, double feb, double mar, double apr, double may, double jun, double jul, double aug, double sep, double oct, double nov, double dec) {
        this.id = id;
        this.fruit = fruit;
        this.jan = jan;
        this.feb = feb;
        this.mar = mar;
        this.apr = apr;
        this.may = may;
        this.jun = jun;
        this.jul = jul;
        this.aug = aug;
        this.sep = sep;
        this.oct = oct;
        this.nov = nov;
        this.dec = dec;
    }

    public FruitPrice(long id, String fruit, String month, double price) {
        this.id = id;
        this.fruit = fruit;
        setPriceForMonth(month, price);
    }

    // Getters and setters for all fields

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

    public double getJan() {
        return jan;
    }

    public void setJan(double jan) {
        this.jan = jan;
    }

    public double getFeb() {
        return feb;
    }

    public void setFeb(double feb) {
        this.feb = feb;
    }

    public double getMar() {
        return mar;
    }

    public void setMar(double mar) {
        this.mar = mar;
    }

    public double getApr() {
        return apr;
    }

    public void setApr(double apr) {
        this.apr = apr;
    }

    public double getMay() {
        return may;
    }

    public void setMay(double may) {
        this.may = may;
    }

    public double getJun() {
        return jun;
    }

    public void setJun(double jun) {
        this.jun = jun;
    }

    public double getJul() {
        return jul;
    }

    public void setJul(double jul) {
        this.jul = jul;
    }

    public double getAug() {
        return aug;
    }

    public void setAug(double aug) {
        this.aug = aug;
    }

    public double getSep() {
        return sep;
    }

    public void setSep(double sep) {
        this.sep = sep;
    }

    public double getOct() {
        return oct;
    }

    public void setOct(double oct) {
        this.oct = oct;
    }

    public double getNov() {
        return nov;
    }

    public void setNov(double nov) {
        this.nov = nov;
    }

    public double getDec() {
        return dec;
    }

    public void setDec(double dec) {
        this.dec = dec;
    }

    public double getPriceForMonth(String month) {
        return switch (month.toLowerCase()) {
            case "jan" -> this.jan;
            case "feb" -> this.feb;
            case "mar" -> this.mar;
            case "apr" -> this.apr;
            case "may" -> this.may;
            case "jun" -> this.jun;
            case "jul" -> this.jul;
            case "aug" -> this.aug;
            case "sep" -> this.sep;
            case "oct" -> this.oct;
            case "nov" -> this.nov;
            case "dec" -> this.dec;
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        };
    }

    public void setPriceForMonth(String month, double price) {
        switch (month.toLowerCase()) {
            case "jan" -> this.jan = price;
            case "feb" -> this.feb = price;
            case "mar" -> this.mar = price;
            case "apr" -> this.apr = price;
            case "may" -> this.may = price;
            case "jun" -> this.jun = price;
            case "jul" -> this.jul = price;
            case "aug" -> this.aug = price;
            case "sep" -> this.sep = price;
            case "oct" -> this.oct = price;
            case "nov" -> this.nov = price;
            case "dec" -> this.dec = price;
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        };
    }
}
