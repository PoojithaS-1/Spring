package com.xworkz.schoolapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.schoolapp")
public class SchoolConfig {
    public SchoolConfig(){
        System.out.println("SchoolConfig cons invoked");
    }
}
