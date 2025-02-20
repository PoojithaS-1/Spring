package com.xworkz.schoolapp.service;

import com.xworkz.schoolapp.dto.SchoolDto;
import com.xworkz.schoolapp.entity.SchoolEntity;

import java.util.List;

public interface SchoolService {
    Boolean validateAndSave(SchoolDto schoolDto);
    SchoolEntity getById(Integer schoolId);

    SchoolEntity getByNoOfClassrooms(Integer noOfClassrooms);

    SchoolEntity getByName(String schoolName);

    Integer updateByName(String schoolName, Integer noOfClassrooms);

    Integer updateById(Integer schoolId, Integer noOfClassrooms);

    Integer deleteById(Integer schoolId);

    List<SchoolDto> getAllData();
}
