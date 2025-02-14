package com.xworkz.houseapp.service;

import com.xworkz.houseapp.dto.HouseDto;

public interface HouseService {
    Boolean validateAndSave(HouseDto houseDto);
}
