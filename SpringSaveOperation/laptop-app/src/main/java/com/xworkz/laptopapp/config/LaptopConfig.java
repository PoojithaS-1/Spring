package com.xworkz.laptopapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.laptopapp")
public class LaptopConfig {
    public LaptopConfig(){
        System.out.println("LaptopConfig cons invoked");
    }
}
