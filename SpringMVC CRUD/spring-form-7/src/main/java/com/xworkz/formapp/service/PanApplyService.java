package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.PanApplyDto;

import java.util.List;

public interface PanApplyService {
    Boolean validateAndSave(PanApplyDto panApplyDto);

    List<PanApplyDto> getAllApplicantInfo();

    void deleteById(int id);
}
