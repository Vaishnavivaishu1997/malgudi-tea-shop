package com.vaishnavi.malgudi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaishnavi.malgudi.entity.Inventory;
import com.vaishnavi.malgudi.repository.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public Inventory save(Inventory inventory) {
        return repository.save(inventory);
    }

    public List<Inventory> getAll() {
        return repository.findAll();
    }

    public Inventory getById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
