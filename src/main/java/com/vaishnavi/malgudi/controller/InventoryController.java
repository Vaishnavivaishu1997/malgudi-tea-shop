package com.vaishnavi.malgudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.vaishnavi.malgudi.entity.Inventory;
import com.vaishnavi.malgudi.service.InventoryService;

@Controller
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping("/inventory")
    public String inventory(Model model) {

        model.addAttribute(
                "items",
                service.getAll());

        return "inventory";
    }

    @GetMapping("/add-inventory")
    public String addInventory(Model model) {

        model.addAttribute(
                "inventory",
                new Inventory());

        return "add-inventory";
    }

    @PostMapping("/save-inventory")
    public String saveInventory(
            Inventory inventory) {

        service.save(inventory);

        return "redirect:/inventory";
    }

    @GetMapping("/edit-inventory/{id}")
    public String editInventory(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "inventory",
                service.getById(id));

        return "edit-inventory";
    }

    @GetMapping("/delete-inventory/{id}")
    public String deleteInventory(
            @PathVariable Long id) {

        service.delete(id);

        return "redirect:/inventory";
    }
}