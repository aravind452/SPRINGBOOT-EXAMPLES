package com.springboot.dto.service;


import com.springboot.dto.dto.PizzaDTO;
import com.springboot.dto.mapper.PizzaMapper;
import com.springboot.dto.model.Pizza;
import com.springboot.dto.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PizzaMapper pizzaMapper;


    public PizzaDTO createPizza(PizzaDTO dto) {
        Pizza pizza = pizzaMapper.toEntity(dto);
        Pizza savedPizza = pizzaRepository.save(pizza);
        return pizzaMapper.toDto(savedPizza);

    }


    public PizzaDTO getPizzaById(Long id) {
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza not found!"));
        return pizzaMapper.toDto(pizza);
    }


    public PizzaDTO updatePizza(Long id, PizzaDTO dto) {
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza not found"));

        pizza.setName(dto.getName());
        pizza.setCategory(dto.getCategory());
        pizza.setSize(dto.getSize());
        pizza.setPrice(dto.getPrice());

        Pizza updatedPizza = pizzaRepository.save(pizza);

        return pizzaMapper.toDto(updatedPizza);
    }


}
