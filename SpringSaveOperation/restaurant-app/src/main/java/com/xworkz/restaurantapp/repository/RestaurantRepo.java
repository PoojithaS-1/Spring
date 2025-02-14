package com.xworkz.restaurantapp.repository;

import com.xworkz.restaurantapp.entity.RestaurantEntity;

public interface RestaurantRepo {
    Boolean save(RestaurantEntity restaurantEntity);
}
