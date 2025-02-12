package com.xworkz.springhasa.independent;
import com.xworkz.springhasa.dependent.SimCard;
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
public class Mobile {

    @Value("Samsung")
    private String brand;

    @Value("Galaxy S22")
    private String model;

    @Value("128GB")
    private String storage;

    @Autowired
    private SimCard simCard;
}
