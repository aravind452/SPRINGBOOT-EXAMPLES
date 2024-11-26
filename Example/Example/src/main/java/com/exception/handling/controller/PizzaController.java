package com.exception.handling.controller;


import com.exception.handling.dto.PizzaDTO;

import com.exception.handling.service.PizzaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;


    @PostMapping("/create")
    @Operation(summary = "Add a new pizza", description = "creates a new pizza")
    public ResponseEntity<PizzaDTO> createPizza(RequestEntity<PizzaDTO> requestEntity) {
        PizzaDTO dto = requestEntity.getBody();
        PizzaDTO createdPizza = pizzaService.createPizza(dto);


        System.out.println("Request Headers: " + requestEntity.getHeaders());

        return ResponseEntity.status(HttpStatus.CREATED).body(createdPizza);
    }


    @GetMapping("/get/{id}")
    @Operation(summary = "get a pizza by id", description = "Retrieves a pizza's details by its ID.")
    public ResponseEntity<PizzaDTO> getPizzaById(@PathVariable Long id) {
        PizzaDTO pizza = pizzaService.getPizzaById(id);
        return ResponseEntity.ok(pizza);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update a pizza", description = "Updates an existing pizza's details by its ID.")
    public ResponseEntity<PizzaDTO> updatePizza(@PathVariable Long id, @RequestBody PizzaDTO dto) {
        PizzaDTO updatedPizza = pizzaService.updatePizza(id, dto);
        return ResponseEntity.ok(updatedPizza);
    }
}
