package com.xworkz.restaurantapp.service;

import com.xworkz.restaurantapp.dto.RestaurantDto;
import com.xworkz.restaurantapp.entity.RestaurantEntity;

import java.util.List;

public interface RestaurantService {
    Boolean validateAndSave(RestaurantDto restaurantDto);
    List<RestaurantDto> getAllData();
    RestaurantEntity getById(Integer restaurantId);
    RestaurantEntity getByNoOfTabels(Integer noOfTables);
    RestaurantEntity getByName(String restaurantName);
    Integer updateByName(String restaurantName, Integer noOfTables);
    Integer updateById(Integer restaurantId, Integer noOfTables);
    Integer deleteById(Integer restaurantId);
}
