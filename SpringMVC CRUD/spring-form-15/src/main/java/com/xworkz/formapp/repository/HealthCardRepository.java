package com.xworkz.formapp.repository;

import com.xworkz.formapp.entity.HealthCardEntity;

import java.util.List;

public interface HealthCardRepository {
    Boolean save(HealthCardEntity healthCardEntity);

    List<HealthCardEntity> getAllApplicantInfo();

    void deleteById(Integer id);
}
