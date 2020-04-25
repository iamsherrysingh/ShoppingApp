package com.sherry.ShoppingApp.ProductMicroService.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name="product")
public class Product {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name="product_name")
    String productName;

    @Column(name="product_description")
    String productDescription;

    @Column(name="product_image")
    byte[] productImage;

    @Column(name="price")
    double price;

    public Product(){}

    public Product(String productName, String productDescription, byte[] productImage, double price) {
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

    public String getProductDescription() {
        return productDescription;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productImage=" + Arrays.toString(productImage) +
                ", price=" + price +
                '}';
    }
}
