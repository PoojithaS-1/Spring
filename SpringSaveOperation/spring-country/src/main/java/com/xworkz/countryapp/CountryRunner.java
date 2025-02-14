package com.xworkz.countryapp;

//import com.xworkz.countryapp.anothercountry.Country;
import com.xworkz.countryapp.configuration.CountryConfiguration;
import com.xworkz.countryapp.dto.CountryDto;
import com.xworkz.countryapp.service.CountryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CountryRunner
{
    public static void main( String[] args )
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(CountryConfiguration.class);
        CountryService countryService = ac.getBean(CountryService.class);

        CountryDto countryDto=new CountryDto();
        countryDto.setCountryName("India");
        countryDto.setPopulation(100000000L);
        countryDto.setNoOfStates(28);
countryService.validateAndSave(countryDto);



    }
}
