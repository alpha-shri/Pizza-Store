package com.pizza.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "Pizza")
public class PizzaImage {
    private String filename;
    private String fileType;
    private String fileSize;
    private byte[] file;
}
