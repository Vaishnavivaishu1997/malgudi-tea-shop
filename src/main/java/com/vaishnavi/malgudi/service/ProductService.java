package com.vaishnavi.malgudi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaishnavi.malgudi.entity.Product;
import com.vaishnavi.malgudi.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }
    
    public Product getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    public void delete(Long id) {
        repository.deleteById(id);
    }

}