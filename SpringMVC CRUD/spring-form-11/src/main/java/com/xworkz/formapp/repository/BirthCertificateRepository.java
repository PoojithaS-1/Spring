package com.xworkz.formapp.repository;

import com.xworkz.formapp.entity.BirthCertificateEntity;

import java.util.List;

public interface BirthCertificateRepository {
    Boolean save(BirthCertificateEntity birthCertificateEntity);

    List<BirthCertificateEntity> getAllApplicantInfo();

    void deleteById(int id);
}
