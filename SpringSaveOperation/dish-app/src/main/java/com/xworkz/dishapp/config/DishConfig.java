package com.xworkz.dishapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.dishapp")
public class DishConfig {
    public DishConfig(){
        System.out.println("DishConfig cons invoked");
    }
}
