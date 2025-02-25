package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.HealthCardDto;

import java.util.List;

public interface HealthCardService {
    Boolean validateAndSave(HealthCardDto healthCardDto);

    List<HealthCardDto> getAllApplicantInfo();

    void deleteById(Integer id);
}
