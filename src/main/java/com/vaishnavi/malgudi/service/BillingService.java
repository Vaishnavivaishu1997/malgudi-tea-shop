package com.vaishnavi.malgudi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public void addToCart(Long productId, Integer quantity) {

        Product product = productRepository
                .findById(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product Not Found"));

        OrderItem item = new OrderItem();

        item.setProductId(product.getId());
        item.setProductName(product.getName());
        item.setPrice(product.getPrice());
        item.setQuantity(quantity);
        item.setTotalPrice(
                product.getPrice() * quantity);

        orderItemRepository.save(item);
    }

    public void deleteItem(Long id) {
        orderItemRepository.deleteById(id);
    }

    public Double getGrandTotal() {

        return orderItemRepository.findAll()
                .stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }
}