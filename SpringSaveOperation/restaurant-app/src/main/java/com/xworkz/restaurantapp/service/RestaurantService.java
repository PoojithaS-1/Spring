package com.xworkz.restaurantapp.service;

import com.xworkz.restaurantapp.dto.RestaurantDto;

public interface RestaurantService {
    Boolean validateAndSave(RestaurantDto restaurantDto);
}
