package com.xworkz.theatreapp.service;

import com.xworkz.theatreapp.dto.TheatreDto;

public interface TheatreService {
    Boolean validateAndSave(TheatreDto theatreDto);
}
