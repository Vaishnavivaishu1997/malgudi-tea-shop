package com.vaishnavi.malgudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vaishnavi.malgudi.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String orders(Model model) {

        model.addAttribute(
                "orders",
                orderService.getAllOrders());

        model.addAttribute(
                "totalSales",
                orderService.getTotalSales());

        return "orders";
    }
}