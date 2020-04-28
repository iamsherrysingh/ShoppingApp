package com.sherry.ProductMicroService.controller;

import com.sherry.ProductMicroService.model.Product;
import com.sherry.ProductMicroService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = {"/products"})
public class ProductController {

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

    @GetMapping(value={"/all" , ""})
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

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }

    @PutMapping("/updatePrice")
    public void updateProduct(@RequestParam("id") Integer id, @RequestParam("newPrice") Double newPrice){
        productService.updatePrice(id, newPrice);
    }
}
