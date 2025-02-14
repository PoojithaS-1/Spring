package com.xworkz.tvapp;

import com.xworkz.tvapp.config.TvConfig;
import com.xworkz.tvapp.dto.TvDto;
import com.xworkz.tvapp.service.TvService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TvRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(TvConfig.class);
        TvService tvService = applicationContext.getBean(TvService.class);
        TvDto tvDto=new TvDto();
        tvDto.setBrand("Sony");
        tvDto.setSize("55 inches");
        tvDto.setResolution("4K");
        tvService.validateAndSave(tvDto);

    }
}
