package com.xworkz.hospitalapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.hospitalapp")
public class HospitalConfig {
    public HospitalConfig(){
        System.out.println("HospitalConfig cons invoked");
    }
}
