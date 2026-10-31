package com.vaishnavi.malgudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vaishnavi.malgudi.entity.Product;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

}
