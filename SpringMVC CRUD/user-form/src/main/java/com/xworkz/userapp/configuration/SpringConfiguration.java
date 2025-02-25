package com.xworkz.userapp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.userapp")
public class SpringConfiguration {
    public SpringConfiguration(){
        System.out.println("SpringConfiguration is created");
    }
}
