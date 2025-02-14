package com.xworkz.patientapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.patientapp")
public class PatientConfig {

    public PatientConfig(){
        System.out.println("PatientConfig cons invoked");
    }
}
