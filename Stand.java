package com.xworkz.coreapp.beans;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@AllArgsConstructor // Commented out because we are using @Autowired, which tells the Spring container to handle constructor injection.
//@NoArgsConstructor // Default constructor causes UnsatisfiedDependencyException: "Unsatisfied dependency expressed through constructor parameter 0."
@ToString
@Component // Class-level annotation to register this class as a Spring bean.
// If this annotation is missing, Spring will throw NoSuchBeanDefinitionException: "No qualifying bean of type 'com.xworkz.coreapp.beans.Stand' available."
public class Stand {

    // Can contain methods
    public void toHold() {
        System.out.println("Holding TV");
    }

    // A Spring bean can be initialized in three ways:

    // 1. Constructor-based initialization
    @Autowired
    public Stand(@Value("2") int id, @Value("Onida") String brandName, @Value("230.00") double price) {
        this.id = id;
        this.brandName = brandName;
        this.price = price;
    }

    // 2. Field-based initialization (directly above properties)
    @Value("3")
    private int id;

    @Value("Majama")
    private String brandName;

    @Value("699.00")
    private double price;

    // 3. Setter-based initialization (directly above setter methods)
    @Value("7")
    public void setId(int id) {
        this.id = id;
    }

    @Value("Dime")
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Value("5678.00")
    public void setPrice(double price) {
        this.price = price;
    }
}
