package com.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "Pizza")
public class Pizza {

    @Id
    private int id;

    @NotBlank
    private String name;
    @NotBlank
    private String size;

    private int price;
}
