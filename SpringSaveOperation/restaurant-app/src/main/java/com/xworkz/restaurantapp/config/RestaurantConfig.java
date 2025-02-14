package com.xworkz.restaurantapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.restaurantapp")
public class RestaurantConfig {
    public RestaurantConfig(){
        System.out.println("RestaurantConfig cons invoked");
    }
}
