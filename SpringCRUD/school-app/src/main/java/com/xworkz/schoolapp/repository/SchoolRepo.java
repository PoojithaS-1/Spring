package com.xworkz.schoolapp.repository;

import com.xworkz.schoolapp.entity.SchoolEntity;

import java.util.List;

public interface SchoolRepo {
    Boolean save(SchoolEntity schoolEntity);
    SchoolEntity getById(Integer schoolId);

    SchoolEntity getByNoOfClassrooms(Integer noOfClassrooms);

    SchoolEntity getByName(String schoolName);

    Integer updateByName(String schoolName, Integer noOfClassrooms);

    Integer updateById(Integer schoolId, Integer noOfClassrooms);

    Integer deleteById(Integer schoolId);

    List<SchoolEntity> getAllData();
}
