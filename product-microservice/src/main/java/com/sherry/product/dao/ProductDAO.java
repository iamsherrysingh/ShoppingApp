package com.sherry.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sherry.product.model.Product;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product where price > ?1", nativeQuery = true)
    List<Product> sortByPriceGreaterThan(Double minPrice);

    @Query(value = "select * from product where price < ?1", nativeQuery = true)
    List<Product> sortByPriceLessThan(Double minPrice);
}
