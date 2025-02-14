package com.xworkz.houseapp;

import com.xworkz.houseapp.config.HouseConfig;
import com.xworkz.houseapp.dto.HouseDto;
import com.xworkz.houseapp.service.HouseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseRunner {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(HouseConfig.class);
        HouseService houseService = ac.getBean(HouseService.class);
        HouseDto houseDto=new HouseDto();
        houseDto.setType("Bungalow");
        houseDto.setFloors("3 Floors");
        houseDto.setGarden("Garden");
        houseService.validateAndSave(houseDto);
    }
}
