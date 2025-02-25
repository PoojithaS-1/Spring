package com.xworkz.form3.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.form3")
public class SpringConfiguration {
    public SpringConfiguration(){
        System.out.println("SpringConfiguration cons is invoked");
    }
}
