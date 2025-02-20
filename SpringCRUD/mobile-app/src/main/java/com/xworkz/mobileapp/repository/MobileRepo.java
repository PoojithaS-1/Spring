package com.xworkz.mobileapp.repository;

import com.xworkz.mobileapp.entity.MobileEntity;

import java.util.List;

public interface MobileRepo {
    Boolean save(MobileEntity mobileEntity);
    MobileEntity getById(Integer id);

    MobileEntity getByBrand(String brand);

    Integer updateByBrand(String brand, String model);

    Integer deleteById(Integer id);

    Integer updateById(Integer id, String model);

    MobileEntity getByModel(String model);


    List<MobileEntity> getAllData();
}
