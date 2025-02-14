package com.xworkz.libapp;

import com.xworkz.libapp.config.LibraryConfig;
import com.xworkz.libapp.dto.LibDto;
import com.xworkz.libapp.service.LibraryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LibraryRunner {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(LibraryConfig.class);
        LibraryService libraryService = ac.getBean(LibraryService.class);
        LibDto libDto=new LibDto();
        libDto.setLibName("Vinayaka");
        libDto.setNoOfBooks(455567);
        libraryService.validateAndSave(libDto);
    }
}
