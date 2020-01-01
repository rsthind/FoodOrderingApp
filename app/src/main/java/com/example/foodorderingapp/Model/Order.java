package com.example.foodorderingapp.Model;

public class Order {
    private String ProductId;
    private String ProductName;
    private String Quantity;
    private String Price;
    private String Discount;

    public Order() {
    }

    public Order(String productId, String productName, String quantity, String price, String discount) {
        this.ProductId = productId;
        this.ProductName = productName;
        this.Quantity = quantity;
        this.Price = price;
        this.Discount = discount;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }
}
