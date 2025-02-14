package com.xworkz.schoolapp;

import com.xworkz.schoolapp.config.SchoolConfig;
import com.xworkz.schoolapp.dto.SchoolDto;
import com.xworkz.schoolapp.service.SchoolService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SchoolRunner {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SchoolConfig.class);
        SchoolService schoolService = ac.getBean(SchoolService.class);
        SchoolDto schoolDto=new SchoolDto();
        schoolDto.setSchoolName("PES");
        schoolDto.setNoOfClassrooms(77);
        schoolDto.setStudentsEnrolled(20000l);
        schoolService.validateAndSave(schoolDto);

    }
}
