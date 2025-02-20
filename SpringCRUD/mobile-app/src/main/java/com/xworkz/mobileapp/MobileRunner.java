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
        mobileDto.setModel("A5s");
        mobileDto.setStorage("112 GB");
        mobileService.validateAndSave(mobileDto);

        mobileService.getById(1);

        mobileService.getByBrand("Oppo");

        mobileService.deleteById(5);

        mobileService.updateByBrand("Oppo","Oppo A11s");

        mobileService.updateById(2,"Y 18");

        mobileService.getByModel("Oppo A11s");

        mobileService.getAllData();
    }
}
