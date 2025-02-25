package com.xworkz.formapp.repository;

import com.xworkz.formapp.entity.VisaApplyEntity;

import java.util.List;

public interface VisaApplyRepository {
    Boolean save(VisaApplyEntity visaApplyEntity);

    List<VisaApplyEntity> getAllApplicantInfo();

    void deleteById(int id);
}
