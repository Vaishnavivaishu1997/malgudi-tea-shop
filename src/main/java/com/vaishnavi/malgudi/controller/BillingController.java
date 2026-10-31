package com.vaishnavi.malgudi.controller;


import com.vaishnavi.malgudi.entity.OrderItem;
import com.vaishnavi.malgudi.entity.Product;
import com.vaishnavi.malgudi.repository.OrderItemRepository;
import com.vaishnavi.malgudi.repository.ProductRepository;
import com.vaishnavi.malgudi.service.BillingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BillingController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;

    @GetMapping("/billing")
    public String billing(Model model) {

        model.addAttribute(
                "products",
                productRepo.findAll());

        model.addAttribute(
                "orders",
                orderItemRepo.findAll());

        return "billing";
    }

    @PostMapping("/save-bill")
    public String saveBill(
            @RequestParam Long productId,
            @RequestParam Integer quantity) {

        Product product =
                productRepo.findById(productId)
                .orElseThrow();

        OrderItem item = new OrderItem();

        item.setProductId(product.getId());
        item.setProductName(product.getName());
        item.setPrice(product.getPrice());
        item.setQuantity(quantity);

        item.setTotalPrice(
                product.getPrice() * quantity);

        orderItemRepo.save(item);

        return "redirect:/billing";
    }
}