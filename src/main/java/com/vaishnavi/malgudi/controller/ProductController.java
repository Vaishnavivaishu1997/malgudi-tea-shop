package com.vaishnavi.malgudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.vaishnavi.malgudi.entity.Product;
import com.vaishnavi.malgudi.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public String products(Model model) {

        model.addAttribute("products",
                service.getAll());

        return "products";
    }

    @GetMapping("/add-product")
    public String addProduct(Model model) {

        model.addAttribute("product",
                new Product());

        return "add-product";
    }

    @PostMapping("/save-product")
    public String saveProduct(Product product) {

        service.save(product);

        return "redirect:/products";
    }
    
    @GetMapping("/edit-product/{id}")
    public String editProduct(@PathVariable Long id,
                              Model model) {

        model.addAttribute(
                "product",
                service.getById(id));

        return "edit-product";
    }
    @GetMapping("/delete-product/{id}")
    public String deleteProduct(
            @PathVariable Long id) {

        service.delete(id);

        return "redirect:/products";
    }
}