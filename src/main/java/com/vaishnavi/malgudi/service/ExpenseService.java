package com.vaishnavi.malgudi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaishnavi.malgudi.entity.Expense;
import com.vaishnavi.malgudi.repository.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    public Expense save(Expense expense) {
        return repository.save(expense);
    }

    public List<Expense> getAll() {
        return repository.findAll();
    }

    public Expense getById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Double getTotalExpenses() {

        return repository.findAll()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }
}