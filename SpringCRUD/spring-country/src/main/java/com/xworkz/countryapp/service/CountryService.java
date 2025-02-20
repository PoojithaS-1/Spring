package com.xworkz.countryapp.service;

import com.xworkz.countryapp.dto.CountryDto;
import com.xworkz.countryapp.entity.CountryEntity;

import java.util.List;

public interface CountryService {
    Boolean validateAndSave(CountryDto countryDto);
    List<CountryDto> getAllData();
    CountryEntity getById(Integer countryId);
    CountryEntity getByNoOfStates(Integer noOfStates);

    CountryEntity getByName(String countryName);
    Integer updateByName(String countryName, Integer noOfStates);
    Integer updateById(Integer countryId, Integer noOfStates);
    Integer deleteById(Integer countryId);
}