package com.sherry.ShoppingApp.ProductMicroService.controller;

import com.sherry.ShoppingApp.ProductMicroService.dao.ProductDAO;
import com.sherry.ShoppingApp.ProductMicroService.model.Product;
import com.sherry.ShoppingApp.ProductMicroService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ProductService productService;

    @GetMapping("/greaterthan/{id}")
    public List<Product> sortByPriceGreaterThan(@PathVariable("id") Double minPrice){
        return productService.sortByPriceGreaterThan(minPrice);
    }

    @GetMapping("/lessthan/{id}")
    public List<Product> sortByPriceLessThan(@PathVariable("id") Double maxPrice){
        return productService.sortByPriceLessThan(maxPrice);
    }

    @GetMapping("/all")
    public List<Product> listProducts() {
        return productService.getProducts();
    }

    /*
     * Usage: localhost:8081/product/1
     */
    @GetMapping("/{id}")
    public Product getUserByUserName(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }
}
