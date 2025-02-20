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
        countryDto.setCountryName("Pakistan");
        countryDto.setPopulation(122000L);
        countryDto.setNoOfStates(10);
countryService.validateAndSave(countryDto);

        countryService.getById(1);

        countryService.getByName("Russia");

        countryService.deleteById(3);

        countryService.updateByName("Pakistan",11);

        countryService.updateById(1,29);

        countryService.getByNoOfStates(40);

        countryService.getAllData();


    }
}
