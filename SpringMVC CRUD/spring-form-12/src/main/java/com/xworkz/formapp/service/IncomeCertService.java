package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.IncomeCertDto;

import java.util.List;

public interface IncomeCertService {
    Boolean validateAndSave(IncomeCertDto incomeCertDto);

    List<IncomeCertDto> getAllApplicantInfo();

    void deleteById(int id);
}
