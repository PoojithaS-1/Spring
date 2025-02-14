package com.xworkz.patientapp;

import com.xworkz.patientapp.config.PatientConfig;
import com.xworkz.patientapp.dto.PatientDto;
import com.xworkz.patientapp.service.PatientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PatientRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(PatientConfig.class);
        PatientService patientService = applicationContext.getBean(PatientService.class);
        PatientDto patientDto=new PatientDto();
        patientDto.setAge(45);
        patientDto.setName("Usha");
        patientService.validateAndSave(patientDto);

    }
}
