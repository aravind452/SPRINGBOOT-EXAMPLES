package com.exception.handling.repo;


import com.exception.handling.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepo extends JpaRepository<Pizza, Long> {
}
