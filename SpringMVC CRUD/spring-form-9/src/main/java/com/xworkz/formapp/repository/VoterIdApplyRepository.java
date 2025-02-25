package com.xworkz.formapp.repository;

import com.xworkz.formapp.entity.VoterIdApplyEntity;

import java.util.List;

public interface VoterIdApplyRepository {
    Boolean save(VoterIdApplyEntity voterIdApplyEntity);

    List<VoterIdApplyEntity> getAllApplicantInfo();

    void deleteById(int id);
}
