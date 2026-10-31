package com.vaishnavi.malgudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.vaishnavi.malgudi.entity.OrderItem;
import com.vaishnavi.malgudi.service.BillingService;

@Controller
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping("/billing")
    public String billing(Model model) {

        model.addAttribute(
                "products",
                billingService.getAllProducts());

        return "billing";
    }

    @PostMapping("/save-bill")
    @ResponseBody
    public String saveBill(
            @RequestBody List<OrderItem> items) {

        billingService.saveItems(items);

        return "Saved Successfully";
    }
}