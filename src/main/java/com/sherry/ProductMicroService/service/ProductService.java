package com.sherry.ProductMicroService.service;

import com.sherry.ProductMicroService.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ProductService {

    public List<Product> getProducts();
    public Product getProductById(Integer id);
    public void addProduct(Product product);
    List<Product> sortByPriceGreaterThan(Double minPrice);
    List<Product> sortByPriceLessThan(Double minPrice);
    public void deleteProduct(Integer id);
    public void updatePrice(Integer id, Double newPrice);

}
