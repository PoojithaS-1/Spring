package com.xworkz.libapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.libapp")
public class LibraryConfig {
    public LibraryConfig(){
        System.out.println("LibraryConfig cons invoked");
    }
}
