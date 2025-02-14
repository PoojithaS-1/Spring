package com.xworkz.mobileapp;

import com.xworkz.mobileapp.config.MobileConfig;
import com.xworkz.mobileapp.dto.MobileDto;
import com.xworkz.mobileapp.service.MobileService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MobileRunner {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MobileConfig.class);
        MobileService mobileService = ac.getBean(MobileService.class);
        MobileDto mobileDto=new MobileDto();
        mobileDto.setBrand("Oppo");
        mobileDto.setModel("Oppo A5s");
        mobileDto.setStorage("64GB");
        mobileService.validateAndSave(mobileDto);
    }
}
