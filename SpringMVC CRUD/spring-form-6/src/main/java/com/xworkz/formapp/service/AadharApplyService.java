package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.AadharApplyDto;

import java.util.List;

public interface AadharApplyService {
    Boolean validateAndSave(AadharApplyDto aadharApplyDto);

    List<AadharApplyDto> getAllApplicantInfo();

    void deleteById(int id);
}
