package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.JobApplyDto;

import java.util.List;

public interface JobApplyService {
    Boolean validateAndSave(JobApplyDto jobApplyDto);

    List<JobApplyDto> getAllApplicantInfo();

    void deleteById(int id);
}
