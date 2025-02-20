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
        schoolDto.setSchoolName("SAV");
        schoolDto.setNoOfClassrooms(30);
        schoolDto.setStudentsEnrolled(200090l);
        schoolService.validateAndSave(schoolDto);
        schoolService.getById(1);

        schoolService.getByName("PES");

        schoolService.deleteById(2);

        schoolService.updateByName("SAV",101);

        schoolService.updateById(2,299);

        schoolService.getByNoOfClassrooms(299);

        schoolService.getAllData();
    }
}
