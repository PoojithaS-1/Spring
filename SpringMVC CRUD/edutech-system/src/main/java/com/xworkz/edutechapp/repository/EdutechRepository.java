package com.xworkz.edutechapp.repository;

import com.xworkz.edutechapp.entity.EduTechEntity;

import java.util.List;

public interface EdutechRepository {
    Boolean save(EduTechEntity eduTechEntity);

    List<EduTechEntity> getAllTraineeInfo();

    void deleteById(Integer id);
}
