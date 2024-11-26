package com.exception.handling.mapper;


import com.exception.handling.dto.PizzaDTO;
import com.exception.handling.model.Pizza;
import org.springframework.stereotype.Component;


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
