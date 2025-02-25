package com.xworkz.formapp.repository;

import com.xworkz.formapp.entity.AadharApplyEntity;

import java.util.List;

public interface AadharApplyRepository {
    Boolean save(AadharApplyEntity aadharApplyEntity);

    List<AadharApplyEntity> getAllApplicantInfo();

    void deleteById(int id);
}
