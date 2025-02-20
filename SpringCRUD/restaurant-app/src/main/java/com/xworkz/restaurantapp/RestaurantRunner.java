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
        restaurantDto.setRestaurantName("Empire");
        restaurantDto.setRevenue(45500000l);
        restaurantDto.setNoOfTables(200);
        restaurantService.validateAndSave(restaurantDto);
        restaurantService.getById(1);

        restaurantService.getByName("Mayura");

        restaurantService.deleteById(2);

        restaurantService.updateByName("Empire",1100);

        restaurantService.updateById(1,900);

        restaurantService.getByNoOfTabels(500);

        restaurantService.getAllData();

    }
}
