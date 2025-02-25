package com.xworkz.formapp.repository;

import com.xworkz.formapp.entity.IncomeCertificateEntity;

import java.util.List;

public interface IncomeCertRepository {
    Boolean save(IncomeCertificateEntity incomeCertEntity);

    List<IncomeCertificateEntity> getAllApplicantInfo();

    void deleteById(int id);
}
