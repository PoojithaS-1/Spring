package com.xworkz.countryapp.repository;

import com.xworkz.countryapp.entity.CountryEntity;

public interface CountryRepository {
    Boolean save(CountryEntity countryEntity);
}
