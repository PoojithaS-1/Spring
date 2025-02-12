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
public class Wife {
    @Value("Girija")
    private String name;
    @Value("46")
    private  Integer age;
    @Value("House Wife")
    private String occupation;
}
