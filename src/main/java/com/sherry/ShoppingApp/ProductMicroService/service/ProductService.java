package com.sherry.ShoppingApp.ProductMicroService.service;

import com.sherry.ShoppingApp.ProductMicroService.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ProductService {

    public List<Product> getProducts();
    public Product getProductById(Integer id);
    public void addProduct(Product product);

}
