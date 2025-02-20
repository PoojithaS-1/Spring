package com.xworkz.restaurantapp.repository;

import com.xworkz.restaurantapp.entity.RestaurantEntity;

import java.util.List;

public interface RestaurantRepo {
    Boolean save(RestaurantEntity restaurantEntity);

    RestaurantEntity getById(Integer restaurantId);

    RestaurantEntity getByNoOfTabels(Integer noOfTables);

    RestaurantEntity getByName(String restaurantName);

    Integer updateByName(String restaurantName, Integer noOfTables);

    Integer updateById(Integer restaurantId, Integer noOfTables);

    Integer deleteById(Integer restaurantId);

    List<RestaurantEntity> getAllData();
}
