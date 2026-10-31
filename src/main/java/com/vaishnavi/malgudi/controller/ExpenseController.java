package com.vaishnavi.malgudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.vaishnavi.malgudi.entity.Expense;
import com.vaishnavi.malgudi.service.ExpenseService;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @GetMapping("/expenses")
    public String expenses(Model model) {

        model.addAttribute(
                "expenses",
                service.getAll());

        model.addAttribute(
                "totalExpense",
                service.getTotalExpenses());

        return "expenses";
    }

    @GetMapping("/add-expense")
    public String addExpense(Model model) {

        model.addAttribute(
                "expense",
                new Expense());

        return "add-expense";
    }

    @PostMapping("/save-expense")
    public String saveExpense(
            Expense expense) {

        service.save(expense);

        return "redirect:/expenses";
    }

    @GetMapping("/edit-expense/{id}")
    public String editExpense(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "expense",
                service.getById(id));

        return "edit-expense";
    }

    @GetMapping("/delete-expense/{id}")
    public String deleteExpense(
            @PathVariable Long id) {

        service.delete(id);

        return "redirect:/expenses";
    }
}