package com.sherry.ShoppingApp.ProductMicroService.controller;

import com.sherry.ShoppingApp.AccountsMicroService.model.User;
import com.sherry.ShoppingApp.ProductMicroService.model.Product;
import com.sherry.ShoppingApp.ProductMicroService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello from ProductController";
    }

    @GetMapping("/products")
    public List<Product> listUsers() {
        return productService.getProducts();
    }

    /*
     * Usage: localhost:8081/product/1
     */
    @GetMapping("/product/{id}")
    public Product getUserByUserName(@PathVariable Integer id){
        return productService.getProductById(id);
    }


}
