package com.example.model;

public class Cart {
    private String itemName, itemAuthor;
    private double itemPrice;
    private int itemImage, itemAmount;

    public Cart(String itemName, String itemAuthor, double itemPrice, int itemImage, int itemAmount) {
        this.itemName = itemName;
        this.itemAuthor = itemAuthor;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
        this.itemAmount = itemAmount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemAuthor() {
        return itemAuthor;
    }

    public void setItemAuthor(String itemAuthor) {
        this.itemAuthor = itemAuthor;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }
}
