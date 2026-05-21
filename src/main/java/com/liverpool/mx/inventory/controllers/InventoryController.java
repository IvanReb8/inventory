package com.liverpool.mx.inventory.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liverpool.mx.inventory.entities.Inventory;
import com.liverpool.mx.inventory.services.InventoryService;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Inventory> findInventory(@PathVariable String productId){
        Inventory inventory = service.findById(productId);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

}
