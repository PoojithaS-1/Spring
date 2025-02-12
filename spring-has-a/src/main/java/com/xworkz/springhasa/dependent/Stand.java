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
public class Stand {

    @Value("Wall Mount")
    private String type;

    @Value("Stainless Steel")
    private String material;
}

