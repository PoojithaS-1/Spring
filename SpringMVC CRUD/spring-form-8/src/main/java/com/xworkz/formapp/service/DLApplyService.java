package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.DLApplyDto;

import java.util.List;

public interface DLApplyService {
    Boolean validateAndSave(DLApplyDto dlApplyDto);

    List<DLApplyDto> getAllApplicantInfo();

    void deleteById(int id);
}
