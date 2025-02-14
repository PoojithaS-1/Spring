package com.xworkz.tvapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

    @Configuration
    @ComponentScan(basePackages = "com.xworkz.tvapp")
    public class TvConfig {

        public TvConfig() {
            System.out.println("TVConfig cons invoked");
        }

}
