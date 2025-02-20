package com.xworkz.countryapp.repository;

import com.xworkz.countryapp.entity.CountryEntity;

import java.util.List;

public interface CountryRepository {
    Boolean save(CountryEntity countryEntity);

    CountryEntity getById(Integer countryId);

    CountryEntity getByNoOfStates(Integer noOfStates);

    CountryEntity getByName(String countryName);

    Integer updateByName(String countryName, Integer noOfStates);

    Integer updateById(Integer countryId, Integer noOfStates);

    Integer deleteById(Integer countryId);

    List<CountryEntity> getAllData();
}
