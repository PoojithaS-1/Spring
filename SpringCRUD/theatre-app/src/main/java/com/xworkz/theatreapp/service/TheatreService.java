package com.xworkz.theatreapp.service;

import com.xworkz.theatreapp.dto.TheatreDto;
import com.xworkz.theatreapp.entity.TheatreEntity;

import java.util.List;

public interface TheatreService {
    Boolean validateAndSave(TheatreDto theatreDto);
    List<TheatreDto> getAllData();
    TheatreEntity getById(Integer id);
    TheatreEntity getByAmenities(String amenities);

    TheatreEntity getByName(String name);
    Integer updateByName(String name, String amenities);
    Integer updateById(Integer id,String amenities);
    Integer deleteById(Integer id);
}
