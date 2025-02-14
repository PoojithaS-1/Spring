package com.xworkz.airplaneapp.service;

import com.xworkz.airplaneapp.dto.AirplaneDto;

public interface AirplaneService {
    Boolean validateAndSave(AirplaneDto airplaneDto);
}
