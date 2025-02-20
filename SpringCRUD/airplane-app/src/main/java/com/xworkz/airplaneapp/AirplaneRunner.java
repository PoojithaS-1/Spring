package com.xworkz.airplaneapp;

import com.xworkz.airplaneapp.config.AirplaneConfig;
import com.xworkz.airplaneapp.dto.AirplaneDto;
import com.xworkz.airplaneapp.service.AirplaneService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AirplaneRunner {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AirplaneConfig.class);
        AirplaneService airplaneService = ac.getBean(AirplaneService.class);
        AirplaneDto airplaneDto=new AirplaneDto();
        airplaneDto.setAirplaneModel("Cessna 172");
        airplaneDto.setNoOfSeats(5000);
        airplaneDto.setTotalPassengers(5000l);
        airplaneService.validateAndSave(airplaneDto);
        airplaneService.getById(1);

        airplaneService.getByModel("Cessna 172");

        airplaneService.deleteById(2);

        airplaneService.updateByModel("Cessna 172",111111);

        airplaneService.updateById(1,299999);

        airplaneService.getByNoOfSeats(299999);

        airplaneService.getAllData();
    }
}
