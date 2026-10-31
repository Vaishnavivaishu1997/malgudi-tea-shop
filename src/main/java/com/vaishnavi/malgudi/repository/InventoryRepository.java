package com.vaishnavi.malgudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaishnavi.malgudi.entity.Inventory;

public interface InventoryRepository
        extends JpaRepository<Inventory, Long> {

}