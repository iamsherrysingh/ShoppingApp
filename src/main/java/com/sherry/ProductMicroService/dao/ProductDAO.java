package com.sherry.ProductMicroService.dao;

import com.sherry.ProductMicroService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product where price > ?1", nativeQuery = true)
    List<Product> sortByPriceGreaterThan(Double minPrice);

    @Query(value = "select * from product where price < ?1", nativeQuery = true)
    List<Product> sortByPriceLessThan(Double minPrice);
}
