package com.xworkz.airplaneapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.airplaneapp")
public class AirplaneConfig {
    public AirplaneConfig(){
        System.out.println("AirplaneConfig cons invoked");
    }
}
