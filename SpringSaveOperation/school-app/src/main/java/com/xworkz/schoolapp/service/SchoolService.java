package com.xworkz.schoolapp.service;

import com.xworkz.schoolapp.dto.SchoolDto;

public interface SchoolService {
    Boolean validateAndSave(SchoolDto schoolDto);
}
