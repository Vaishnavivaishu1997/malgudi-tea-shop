package com.vaishnavi.malgudi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.vaishnavi.malgudi.entity.Expense;
import com.vaishnavi.malgudi.entity.Inventory;
import com.vaishnavi.malgudi.entity.OrderItem;
import com.vaishnavi.malgudi.repository.ProductRepository;

import com.vaishnavi.malgudi.repository.ExpenseRepository;
import com.vaishnavi.malgudi.repository.InventoryRepository;
import com.vaishnavi.malgudi.repository.OrderItemRepository;

@Service
public class DashboardService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public long getProductCount() {
        return productRepository.count();
    }

    public long getOrderCount() {
        return orderRepository.count();
    }

    public double getTotalSales() {

        return orderRepository.findAll()
                .stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }

    public double getTotalExpenses() {

        return expenseRepository.findAll()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public double getProfit() {

        return getTotalSales()
                - getTotalExpenses();
    }

    public long getLowStockCount() {

        return inventoryRepository.findAll()
                .stream()
                .filter(item ->
                        item.getQuantity()
                        <= item.getMinimumStock())
                .count();
    }

}