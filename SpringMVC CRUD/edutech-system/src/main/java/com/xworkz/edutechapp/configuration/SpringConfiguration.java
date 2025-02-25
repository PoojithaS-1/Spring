package com.xworkz.edutechapp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.edutechapp")
public class SpringConfiguration {
    public SpringConfiguration(){
        System.out.println("SpringConfiguration cons invoked");
    }
}
