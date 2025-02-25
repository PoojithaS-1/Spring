package com.xworkz.formapp.repository;

import com.xworkz.formapp.entity.RationCardEntity;

import java.util.List;

public interface RationCardRepository {
    Boolean save(RationCardEntity rationCardEntity);

    List<RationCardEntity> getAllApplicantInfo();

    void deleteById(int id);
}
