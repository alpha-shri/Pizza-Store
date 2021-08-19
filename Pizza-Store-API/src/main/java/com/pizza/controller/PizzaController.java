package com.pizza.controller;

import com.pizza.model.Pizza;
import com.pizza.services.PizzaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza-service")
@CrossOrigin("*")
public class PizzaController {

    // Constructor-Injection
    private final PizzaService pizzaService;
    public PizzaController(PizzaService pizzaService){
        this.pizzaService = pizzaService;
    }


    @GetMapping("/fetchall")
    public ResponseEntity<List<Pizza>> fetchAll(){
        List<Pizza> pizzas = pizzaService.fetchAllPizzaService();
        return new ResponseEntity<>(pizzas, HttpStatus.OK);
    }

}
