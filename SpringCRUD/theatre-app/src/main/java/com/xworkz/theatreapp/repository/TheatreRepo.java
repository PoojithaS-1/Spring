package com.xworkz.theatreapp.repository;

import com.xworkz.theatreapp.entity.TheatreEntity;

import java.util.List;

public interface TheatreRepo {
    Boolean save(TheatreEntity theatreEntity);

    TheatreEntity getById(Integer id);

    TheatreEntity getByName(String name);

    Integer updateByName(String name, String amenities);

    Integer deleteById(Integer id);

    Integer updateById(Integer id, String amenities);

    TheatreEntity getByAmenities(String amenities);


    List<TheatreEntity> getAllData();
}
