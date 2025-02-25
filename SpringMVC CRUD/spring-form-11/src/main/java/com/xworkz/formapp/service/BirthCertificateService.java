package com.xworkz.formapp.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xworkz.formapp.dto.BirthCertificateDto;

import java.util.List;

public interface BirthCertificateService {
    Boolean validateAndSave(BirthCertificateDto birthCertificateDto);

    List<BirthCertificateDto> getAllApplicantInfo();

    void deleteById(int id);
}
