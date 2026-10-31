package com.vaishnavi.malgudi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.vaishnavi.malgudi.entity.OrderItem;
import com.vaishnavi.malgudi.repository.OrderItemRepository;


@Service
public class OrderService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrders() {
        return orderItemRepository.findAll();
    }

    public Double getTotalSales() {
        return orderItemRepository.findAll()
                .stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }
}