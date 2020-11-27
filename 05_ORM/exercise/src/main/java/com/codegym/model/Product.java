package com.codegym.model;

import javax.persistence.*;

@Entity(name = "product")
public class Product {
//    PRIMARY KEY AUTO_INCREMENT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    private String nameProduct;
    private double price;
    private int amount;
    private String describeProduct;
    private String producer;

    public Product() {
    }

//    public Product(Integer idProduct, String nameProduct, double price, int amount, String describe, String producer) {
//        this.idProduct = idProduct;
//        this.nameProduct = nameProduct;
//        this.price = price;
//        this.amount = amount;
//        this.describe = describe;
//        this.producer = producer;
//    }
//
//    public Product(String nameProduct, double price, int amount, String describe, String producer) {
//        this.nameProduct = nameProduct;
//        this.price = price;
//        this.amount = amount;
//        this.describe = describe;
//        this.producer = producer;
//    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
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

    public String getDescribeProduct() {
        return describeProduct;
    }

    public void setDescribeProduct(String describeProduct) {
        this.describeProduct = describeProduct;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
