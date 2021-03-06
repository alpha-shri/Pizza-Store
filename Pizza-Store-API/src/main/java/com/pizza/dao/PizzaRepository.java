package com.pizza.dao;

import com.pizza.model.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends MongoRepository<Pizza, Integer> {
}
