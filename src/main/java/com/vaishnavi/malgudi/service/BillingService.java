package com.vaishnavi.malgudi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaishnavi.malgudi.entity.OrderItem;
import com.vaishnavi.malgudi.entity.Product;
import com.vaishnavi.malgudi.repository.OrderItemRepository;
import com.vaishnavi.malgudi.repository.ProductRepository;

@Service
public class BillingService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional
    public void saveItems(List<OrderItem> items) {

        for(OrderItem item : items){

            Product product =
                    productRepository.findById(
                            item.getProductId())
                    .orElseThrow();

            if(product.getStock() < item.getQuantity()){

                throw new RuntimeException(
                    product.getName() +
                    " stock not available");
            }

            product.setStock(
                product.getStock()
                - item.getQuantity()
            );

            productRepository.save(product);

            orderItemRepository.save(item);
        }
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}