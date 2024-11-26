package com.exception.handling.service;


import com.exception.handling.customexception.PizzaException;
import com.exception.handling.dto.PizzaDTO;
import com.exception.handling.mapper.PizzaMapper;
import com.exception.handling.repo.PizzaRepo;


import com.exception.handling.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepo pizzaRepo;


    @Autowired
    private PizzaMapper pizzaMapper;

    public PizzaDTO createPizza(PizzaDTO dto) {
        Pizza pizza = pizzaMapper.toEntity(dto);
        Pizza savedPizza = pizzaRepo.save(pizza);
        return pizzaMapper.toDto(savedPizza);

    }


    public PizzaDTO getPizzaById(Long id) {
        Pizza pizza = pizzaRepo.findById(id)
                .orElseThrow(() -> new PizzaException("Pizza not found!"));
        return pizzaMapper.toDto(pizza);
    }


    public PizzaDTO updatePizza(Long id, PizzaDTO dto) {
        Pizza pizza = pizzaRepo.findById(id)
                .orElseThrow(() -> new PizzaException("Pizza not found and can't be updated!!!"));

        pizza.setName(dto.getName());
        pizza.setCategory(dto.getCategory());
        pizza.setSize(dto.getSize());
        pizza.setPrice(dto.getPrice());

        Pizza updatedPizza = pizzaRepo.save(pizza);

        return pizzaMapper.toDto(updatedPizza);
    }
}
