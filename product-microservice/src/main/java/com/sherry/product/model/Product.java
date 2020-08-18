package com.sherry.product.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "product_name")
    String productName;

    @Column(name = "product_description")
    String productDescription;

    @Column(name = "product_image")
    String productImage;

    @Column(name = "price")
    double price;

    public Product() {
    }

    public Product(String productName, String productDescription, String productImage, double price) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productImage=" + productImage +
                ", price=" + price +
                '}';
    }
}
