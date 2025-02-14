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
        airplaneDto.setAirplaneModel("Airbus A320");
        airplaneDto.setNoOfSeats(500);
        airplaneDto.setTotalPassengers(34567l);
        airplaneService.validateAndSave(airplaneDto);
    }
}
