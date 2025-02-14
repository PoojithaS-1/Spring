package com.xworkz.countryapp.service;

import com.xworkz.countryapp.dto.CountryDto;

public interface CountryService {
    Boolean validateAndSave(CountryDto countryDto);
}
