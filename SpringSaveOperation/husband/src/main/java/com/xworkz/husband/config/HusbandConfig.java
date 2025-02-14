package com.xworkz.husband.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.husband")
public class HusbandConfig {
    public HusbandConfig(){
        System.out.println("HusbandConfig cons invoked");
    }
}
