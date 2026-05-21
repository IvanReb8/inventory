package com.liverpool.mx.inventory.services;

import com.liverpool.mx.inventory.entities.Inventory;

public interface InventoryService {

    Inventory findById(String id);

}
