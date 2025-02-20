package com.xworkz.bankapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.bankapp")
public class BankConfig {
    public BankConfig(){
        System.out.println("BankConfig cons invoked");
    }
}
