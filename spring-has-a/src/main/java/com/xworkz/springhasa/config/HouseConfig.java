package com.xworkz.springhasa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.springhasa")
public class HouseConfig {

    public HouseConfig() {
        System.out.println("HouseConfig cons invoked");
    }
}
