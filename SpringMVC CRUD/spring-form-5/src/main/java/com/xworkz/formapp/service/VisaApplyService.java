package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.VisaApplyDto;

import java.util.List;

public interface VisaApplyService {
    Boolean validateAndSave(VisaApplyDto visaApplyDto);

    List<VisaApplyDto> getAllApplicantInfo();

    void deleteById(int id);
}
