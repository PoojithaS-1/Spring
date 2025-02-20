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
        theatreDto.setName("INOX Leisure");
        theatreDto.setType("Multiplex");
        theatreService.validateAndSave(theatreDto);

        theatreService.getById(1);

        theatreService.getByName("Cinepolis");

        theatreService.deleteById(5);

        theatreService.updateByName("Cinepolis","Non-AC");

        theatreService.updateById(1,"Non-AC");

        theatreService.getByAmenities("AC");

        theatreService.getAllData();

    }
}
