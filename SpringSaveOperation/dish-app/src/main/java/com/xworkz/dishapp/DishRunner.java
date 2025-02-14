package com.xworkz.dishapp;

import com.xworkz.dishapp.config.DishConfig;
import com.xworkz.dishapp.dto.DishDto;
import com.xworkz.dishapp.service.DishService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DishRunner {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DishConfig.class);
        DishService dishService = ac.getBean(DishService.class);
        DishDto dishDto=new DishDto();
        dishDto.setName("Biryani");
        dishDto.setCuisine("Indian");
        dishDto.setTaste("Spicy");
        dishService.validateAndSave(dishDto);
    }
}
