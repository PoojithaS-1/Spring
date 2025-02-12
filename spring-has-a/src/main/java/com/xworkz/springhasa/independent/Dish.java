package com.xworkz.springhasa.independent;

import com.xworkz.springhasa.dependent.Ingredient;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@ToString
public class Dish {

    @Value("Biryani")
    private String name;

    @Value("Indian")
    private String cuisine;

    @Value("Spicy")
    private String taste;

    @Autowired
    private Ingredient ingredient;
}

