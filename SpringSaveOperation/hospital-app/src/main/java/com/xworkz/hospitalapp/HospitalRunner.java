package com.xworkz.hospitalapp;

import com.xworkz.hospitalapp.config.HospitalConfig;
import com.xworkz.hospitalapp.dto.HospitalDto;
import com.xworkz.hospitalapp.service.HospitalService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HospitalRunner {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(HospitalConfig.class);
        HospitalService hospitalService = ac.getBean(HospitalService.class);
        HospitalDto hospitalDto=new HospitalDto();
        hospitalDto.setHospitalName("Durga");
        hospitalDto.setNoOfBeds(59);
        hospitalDto.setPatientsServed(4567800L);
        hospitalService.validateAndSave(hospitalDto);

    }
}
