package com.sherry.ShoppingApp.ProductMicroService.dao;

import com.sherry.ShoppingApp.ProductMicroService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {


}
