package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.VoterIdApplyDto;

import java.util.List;

public interface VoterIdApplyService {
    Boolean validateAndSave(VoterIdApplyDto voterIdApplyDto);

    List<VoterIdApplyDto> getAllApplicantInfo();

    void deleteById(int id);
}
