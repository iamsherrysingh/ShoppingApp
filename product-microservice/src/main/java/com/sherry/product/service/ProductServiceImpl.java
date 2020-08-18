package com.sherry.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.sherry.product.dao.ProductDAO;
import com.sherry.product.model.Product;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Cacheable(cacheNames = "getProductsCache")
    @Override
    public List<Product> getProducts() {
        List<Product> products = productDAO.findAll();
        return products;
    }

    @Cacheable(cacheNames = "getProductsByIdCache", key = "#id")
    @Override
    public Product getProductById(Integer id) {
        Optional<Product> product = productDAO.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            return new Product();
        }
    }

    //Using the allEntries attribute to evict all entries from the cache.
    @CacheEvict(cacheNames = {"getProductsCache"}, allEntries = true)
    @Override
    public void addProduct(Product product) {
        productDAO.save(product);
    }

    @Override
    public List<Product> sortByPriceGreaterThan(Double minPrice) {
        return productDAO.sortByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> sortByPriceLessThan(Double minPrice) {
        return productDAO.sortByPriceLessThan(minPrice);
    }

    @Caching(evict = {@CacheEvict(cacheNames = {"getProductsCache"}, allEntries = true),
            @CacheEvict(cacheNames = "getProductsByIdCache", key = "#id")})
    @Override
    public void deleteProduct(Integer id) {
        productDAO.delete(getProductById(id));
    }

    @Caching(evict = {@CacheEvict(cacheNames = {"getProductsCache"}, allEntries = true),
            @CacheEvict(cacheNames = "getProductsByIdCache", key = "#id")})
    @Override
    public void updatePrice(Integer id, Double newPrice) {
        Product product = getProductById(id);
        product.setPrice(newPrice);
        productDAO.save(product);

    }


}
