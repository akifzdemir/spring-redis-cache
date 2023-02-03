package com.example.springredis.services;

import com.example.springredis.models.Product;
import com.example.springredis.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @CacheEvict(cacheNames = "products", allEntries = true)
    public void add(Product product){
        productRepository.save(product);
    }

    @Caching(evict = { @CacheEvict(cacheNames = "product", key = "#id"),
            @CacheEvict(cacheNames = "products", allEntries = true) })
    public void delete(int id){
        productRepository.deleteById(id);
    }

    @Caching(evict = { @CacheEvict(cacheNames = "product", key = "#id"),
            @CacheEvict(cacheNames = "products", allEntries = true) })
    public void update(int id,Product product){
        Product productToUpdate = productRepository.findById(id).get();
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productRepository.save(productToUpdate);
    }

    @Cacheable(cacheNames = "products")
    public List<Product> getAll(){
        waitTest();
        return productRepository.findAll();
    }


    @Cacheable(cacheNames = "product",key = "#id")
    public Product getById(int id){
        waitTest();
        return productRepository.findById(id).get();
    }

    private void waitTest(){
        try {
            System.out.println("Wait");
            Thread.sleep(2000);
            System.out.println("Wait ended");
        }catch (Exception e){
            System.out.println(e);
        }

    }

}
