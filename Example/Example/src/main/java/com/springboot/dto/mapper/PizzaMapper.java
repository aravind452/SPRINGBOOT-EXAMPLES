package com.springboot.dto.mapper;


import com.springboot.dto.dto.PizzaDTO;
import com.springboot.dto.model.Pizza;
import org.springframework.stereotype.Component;


// Mapper - A Class that converts the Pizza to PizzaDTO
@Component
public class PizzaMapper {

    public PizzaDTO toDto(Pizza pizza) {
        PizzaDTO dto = new PizzaDTO();
        dto.setName(pizza.getName());
        dto.setCategory(pizza.getCategory());
        dto.setPrice(pizza.getPrice());
        dto.setSize(pizza.getSize());
        return dto;
    }


    public Pizza toEntity(PizzaDTO dto) {
        Pizza pizza = new Pizza();
        pizza.setName(dto.getName());
        pizza.setCategory(dto.getCategory());
        pizza.setPrice(dto.getPrice());
        pizza.setSize(dto.getSize());
        return pizza;
    }
}
