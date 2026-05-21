package com.liverpool.mx.inventory;

import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liverpool.mx.inventory.entities.Inventory;
import com.liverpool.mx.inventory.repositories.InventoryRepository;

@Configuration
public class LoadDataConfig {

    @Bean
    CommandLineRunner startDataBase(InventoryRepository repository){
        return args -> {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/inventory.json")) {
                ObjectMapper objectMapper = new ObjectMapper();
                List<Inventory> inventories = objectMapper.readValue(inputStream, new TypeReference<List<Inventory>>(){});

                repository.saveAll(inventories);
                System.out.println("Data successfully loaded from JSON!");
            } catch (Exception e) {
                System.out.println("Error loading data: " + e.getMessage());
            }
        };
    }
    

}
