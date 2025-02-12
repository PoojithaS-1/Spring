package com.xworkz.springhasa;

import com.xworkz.springhasa.config.PatientConfig;
import com.xworkz.springhasa.independent.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(PatientConfig.class);

        Patient patient = ac.getBean(Patient.class);
        System.out.println(patient);

        Library library = ac.getBean(Library.class);
        System.out.println(library);

        Husband husband = ac.getBean(Husband.class);
        System.out.println(husband);

        Mobile mobile = ac.getBean(Mobile.class);
        System.out.println(mobile);

        Tv tv = ac.getBean(Tv.class);
        System.out.println(tv);

        Laptop laptop = ac.getBean(Laptop.class);
        System.out.println(laptop);

        House house = ac.getBean(House.class);
        System.out.println(house);

        Dish dish = ac.getBean(Dish.class);
        System.out.println(dish);

        Theatre theatre = ac.getBean(Theatre.class);
        System.out.println(theatre);




    }
}
