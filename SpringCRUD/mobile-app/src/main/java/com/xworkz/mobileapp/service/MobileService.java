package com.xworkz.mobileapp.service;

import com.xworkz.mobileapp.dto.MobileDto;
import com.xworkz.mobileapp.entity.MobileEntity;

import java.util.List;

public interface MobileService {
    Boolean validateAndSave(MobileDto mobileDto);

    List<MobileDto> getAllData();
    MobileEntity getById(Integer id);
    MobileEntity getByModel(String model);

    MobileEntity getByBrand(String brand);
    Integer updateByBrand(String brand, String model);
    Integer updateById(Integer id,String model);
    Integer deleteById(Integer id);
}