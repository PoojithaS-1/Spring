package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.ScholarshipDto;

import java.util.List;

public interface ScholarshipService {
    Boolean validateAndSave(ScholarshipDto scholarshipDto);

    List<ScholarshipDto> getAllApplicantInfo();

    void deleteById(int id);
}
