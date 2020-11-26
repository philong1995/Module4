package com.codegym.model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double price;
    private int amount;
    private String describe;
    private String producer;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, double price, int amount, String describe, String producer) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.describe = describe;
        this.producer = producer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
