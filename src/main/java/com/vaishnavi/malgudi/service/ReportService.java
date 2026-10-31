package com.vaishnavi.malgudi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaishnavi.malgudi.entity.OrderItem;
import com.vaishnavi.malgudi.entity.Expense;

import com.vaishnavi.malgudi.repository.ExpenseRepository;
import com.vaishnavi.malgudi.repository.OrderItemRepository;

@Service
public class ReportService {

    @Autowired
    private OrderItemRepository orderRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    public Double getTotalSales() {

        return orderRepository.findAll()
                .stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }

    public Double getTotalExpenses() {

        return expenseRepository.findAll()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public Double getProfit() {

        return getTotalSales()
                - getTotalExpenses();
    }

    public Long getTotalOrders() {

        return orderRepository.count();
    }

    public List<OrderItem> getAllOrders() {

        return orderRepository.findAll();
    }

    public List<Expense> getAllExpenses() {

        return expenseRepository.findAll();
    }
}