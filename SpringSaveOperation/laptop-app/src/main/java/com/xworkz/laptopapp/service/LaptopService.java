package com.xworkz.laptopapp.service;

import com.xworkz.laptopapp.dto.LaptopDto;

public interface LaptopService {
    Boolean validateAndSave(LaptopDto laptopDto);
}
