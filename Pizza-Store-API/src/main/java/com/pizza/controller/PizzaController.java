package com.pizza.controller;

import com.pizza.model.Pizza;
import com.pizza.model.PizzaImage;
import com.pizza.services.PizzaService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @GetMapping("/find/{id}")
    public ResponseEntity<Pizza> findById(@PathVariable int id){
        Pizza pizza = pizzaService.findByIdService(id);
        return new ResponseEntity<>(pizza, HttpStatus.OK);

    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(pizzaService.addFileService(file), HttpStatus.OK);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
        PizzaImage pizzaImage = pizzaService.downloadFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(pizzaImage.getFileType() ))
                .header(HttpHeaders.CONTENT_DISPOSITION,
        "attachment;" +
                        "filename=\"" + pizzaImage.getFilename() + "\"")
                .body(new ByteArrayResource(pizzaImage.getFile()));
    }



}
