package com.xworkz.theatreapp;

import com.xworkz.theatreapp.config.TheatreConfig;
import com.xworkz.theatreapp.dto.TheatreDto;
import com.xworkz.theatreapp.service.TheatreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TheatreRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(TheatreConfig.class);
        TheatreService theatreService = applicationContext.getBean(TheatreService.class);
        TheatreDto theatreDto=new TheatreDto();
        theatreDto.setAmenities("AC");
        theatreDto.setName("PVR");
        theatreDto.setType("Multiplex");
        theatreService.validateAndSave(theatreDto);

    }
}
