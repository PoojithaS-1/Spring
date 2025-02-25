package com.xworkz.formapp.repository;

import com.xworkz.formapp.entity.ScholarshipEntity;

import java.util.List;

public interface ScholarshipRepository {
    Boolean save(ScholarshipEntity scholarshipEntity);

    List<ScholarshipEntity> getAllApplicantInfo();

    void deleteById(int id);
}
