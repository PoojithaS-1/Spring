package com.xworkz.springhasa.dependent;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@ToString
public class Ingredient {

    @Value("Basmati Rice")
    private String rice;

    @Value("Chicken")
    private String protein;

    @Value("Spices")
    private String spices;
}
