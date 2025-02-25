package com.xworkz.formapp.repository;

import com.xworkz.formapp.entity.PanApplyEntity;

import java.util.List;

public interface PanApplyRepository {
    Boolean save(PanApplyEntity panApplyEntity);

    List<PanApplyEntity> getAllApplicantInfo();

    void deleteById(int id);
}
