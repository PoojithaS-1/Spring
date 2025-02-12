package com.xworkz.countryapp.configuration;

import com.xworkz.countryapp.country.Country;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.xworkz.countryapp")
public class CountryConfiguration {

    public Country getCountry(){
        Country country=new Country();
        System.out.println(country);
        return country;
    }
    @Bean
    public List getList(){
        return new ArrayList<>();
    }
    @Bean
    public String getString(){
        String str="Poojitha";
        return str;
    }
    @Bean
    public Byte getByte(){
        byte abyte= 76;
        return abyte;
    }
    @Bean
    public Long getLong(){
       return 3456789009988L;
    }
    @Bean
    public Integer getInterger(){
        return 3;
    }
    @Bean
    public Boolean getBoolean(){
        return true;
    }
    @Bean
    public Short getShort(){
        return 2;
    }
    @Bean
    public Double getDouble(){
        return 2.00;
    }
    @Bean
    public Float getFloat(){
        return 77.00f;
    }


}
