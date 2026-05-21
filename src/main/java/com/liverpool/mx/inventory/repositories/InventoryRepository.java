package com.liverpool.mx.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liverpool.mx.inventory.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, String> {

}
