package com.liverpool.mx.inventory.services;

import org.springframework.stereotype.Service;

import com.liverpool.mx.inventory.entities.Inventory;
import com.liverpool.mx.inventory.exceptions.NotFoundResourceException;
import com.liverpool.mx.inventory.repositories.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository repository;

    public InventoryServiceImpl(InventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Inventory findById(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundResourceException(id));
    }

}
