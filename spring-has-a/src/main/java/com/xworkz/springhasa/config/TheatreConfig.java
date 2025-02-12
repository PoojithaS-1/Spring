package com.xworkz.springhasa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.springhasa")
public class TheatreConfig {

    public TheatreConfig() {
        System.out.println("TheatreConfig cons invoked");
    }
}
