package com.xworkz.husband;

import com.xworkz.husband.config.HusbandConfig;
import com.xworkz.husband.dto.HusbandDto;
import com.xworkz.husband.service.HusbandService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HusbandRunner {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(HusbandConfig.class);
        HusbandService husbandService = ac.getBean(HusbandService.class);
        HusbandDto husbandDto=new HusbandDto();
        husbandDto.setName("Srinivas");
        husbandDto.setOccupation("Farmer");
        husbandDto.setAge(55);
        husbandService.validateAndSave(husbandDto);

    }
}
