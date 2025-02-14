package com.xworkz.restaurantapp;

import com.xworkz.restaurantapp.config.RestaurantConfig;
import com.xworkz.restaurantapp.dto.RestaurantDto;
import com.xworkz.restaurantapp.service.RestaurantService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RestaurantRunner {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(RestaurantConfig.class);
        RestaurantService restaurantService = ac.getBean(RestaurantService.class);
        RestaurantDto restaurantDto=new RestaurantDto();
        restaurantDto.setRestaurantName("Taj");
        restaurantDto.setRevenue(40000000l);
        restaurantDto.setNoOfTables(300);
        restaurantService.validateAndSave(restaurantDto);
    }
}
