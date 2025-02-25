package com.xworkz.formapp.repository;

import com.xworkz.formapp.entity.PassportRegEntity;

import java.util.List;

public interface PassportRegRepository {
    Boolean save(PassportRegEntity passportRegEntity);

    List<PassportRegEntity> getAllApplicantInfo();

    void deleteById(int id);
}
