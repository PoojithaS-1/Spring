package com.xworkz.dishapp.repository;

import com.xworkz.dishapp.entity.DishEntity;

public interface DishRepo {
    Boolean save(DishEntity dishEntity);
}
