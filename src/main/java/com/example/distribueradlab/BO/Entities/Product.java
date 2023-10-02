package com.example.distribueradlab.BO.Entities;

import java.util.Arrays;

public class Product {

    private  String name;
    private  String description;
    private  int quantity;
    private  double price;
    private  Integer id;
    private  byte[] image;
    private String base64Image;

    public Product(){

    }

    public Product(String name, String description, int quantity, double price, Integer id, byte[] image, String base64Image) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
        this.image = image;
        this.base64Image = base64Image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", id=" + id +
                ", image=" + Arrays.toString(image) +
                ", base64Image='" + base64Image + '\'' +
                '}';
    }
}





