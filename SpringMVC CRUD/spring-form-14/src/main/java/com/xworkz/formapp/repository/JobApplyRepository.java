package com.xworkz.formapp.repository;

import com.xworkz.formapp.entity.JobApplyEntity;

import java.util.List;

public interface JobApplyRepository {
    Boolean save(JobApplyEntity jobApplyEntity);

    List<JobApplyEntity> getAllApplicantInfo();

    void deleteById(int id);
}
