package com.xworkz.countryapp;

//import com.xworkz.countryapp.anothercountry.Country;
import com.xworkz.countryapp.configuration.CountryConfiguration;
import com.xworkz.countryapp.country.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class CountryRunner
{
    public static void main( String[] args )
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(CountryConfiguration.class);
        Country country = ac.getBean("oldCountry", Country.class);
        System.out.println(country);


//        List list=new ArrayList<>();
//        list.add(45);
//        list.add(76);
//        ac.getBean(List.class);
//        System.out.println(list);
//
//        String string=ac.getBean(String.class);
//        System.out.println(string);
//
//        Integer integer=ac.getBean(Integer.class);
//        System.out.println(integer);
//
//        Long aLong = ac.getBean(Long.class);
//        System.out.println(aLong);
//
//        Byte aByte = ac.getBean(Byte.class);
//        System.out.println(aByte);
//
//        Boolean aBoolean = ac.getBean(Boolean.class);
//        System.out.println(aBoolean);
//
//        Short aShort = ac.getBean(Short.class);
//        System.out.println(aShort);
//        Double aDouble = ac.getBean(Double.class);
//        System.out.println(aDouble);
//        Float aFloat=ac.getBean(Float.class);
//        System.out.println(aFloat);


    }
}
