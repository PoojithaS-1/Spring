package com.xworkz.laptopapp;

import com.xworkz.laptopapp.config.LaptopConfig;
import com.xworkz.laptopapp.dto.LaptopDto;
import com.xworkz.laptopapp.service.LaptopService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LaptopRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(LaptopConfig.class);
        LaptopService laptopService = applicationContext.getBean(LaptopService.class);
        LaptopDto laptopDto=new LaptopDto();
        laptopDto.setBrand("Dell");
        laptopDto.setModel("Inspiron");
        laptopDto.setRam("16GB");
        laptopService.validateAndSave(laptopDto);

    }
}
