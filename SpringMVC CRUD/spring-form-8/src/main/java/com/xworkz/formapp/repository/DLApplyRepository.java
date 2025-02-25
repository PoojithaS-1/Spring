package com.xworkz.formapp.repository;

import com.xworkz.formapp.entity.DLApplyEntity;

import java.util.List;

public interface DLApplyRepository {
    Boolean save(DLApplyEntity dlApplyEntity);

    List<DLApplyEntity> getAllApplicantInfo();

    void deleteById(int id);
}
