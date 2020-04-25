package com.sherry.ShoppingApp.ProductMicroService.service;

import com.sherry.ShoppingApp.ProductMicroService.dao.ProductDAO;
import com.sherry.ShoppingApp.ProductMicroService.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDAO productDAO;

    @Override
    public List<Product> getProducts() {
        List<Product> products= productDAO.findAll();
        return products;
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> product= productDAO.findById(id);
        if(product.isPresent()){
            return product.get();
        }else {
            return new Product();
        }
    }
}
