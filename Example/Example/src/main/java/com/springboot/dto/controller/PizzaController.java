package com.springboot.dto.controller;


import com.springboot.dto.dto.PizzaDTO;
import com.springboot.dto.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {


    @Autowired
    private PizzaService pizzaService;


    @PostMapping("/create")
    public PizzaDTO createPizza(@RequestBody PizzaDTO dto) {

        return pizzaService.createPizza(dto);

    }

    @GetMapping("/get/{id}")
    public PizzaDTO getPizzaById(@PathVariable Long id) {
        return pizzaService.getPizzaById(id);
    }

    @PutMapping("/update/{id}")
    public PizzaDTO updatePizza(@PathVariable Long id, @RequestBody PizzaDTO dto) {
        return pizzaService.updatePizza(id, dto);
    }


}
