package com.xworkz.formapp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.formapp")
public class SpringConfiguration {
    public SpringConfiguration(){
        System.out.println("SpringConfiguration cons is invoked");
    }
}
