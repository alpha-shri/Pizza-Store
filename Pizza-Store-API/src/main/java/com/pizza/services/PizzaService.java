package com.pizza.services;

import com.pizza.dao.PizzaRepository;
import com.pizza.model.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

// Constructor-Injection
    private final PizzaRepository dao;
    public PizzaService(PizzaRepository dao){
        this.dao = dao;
    }

    public List<Pizza> fetchAllPizzaService(){
        return dao.findAll();
    }
}
