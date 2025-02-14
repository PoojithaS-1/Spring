package com.xworkz.dishapp.service;

import com.xworkz.dishapp.dto.DishDto;

public interface DishService {
    Boolean validateAndSave(DishDto dishDto);
}
