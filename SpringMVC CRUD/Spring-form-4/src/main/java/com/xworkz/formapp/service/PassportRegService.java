package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.PassportRegDto;

import java.util.List;

public interface PassportRegService {
    Boolean validateAndSave(PassportRegDto passportRegDto);

    List<PassportRegDto> getAllApplicantInfo();

    void deleteById(int id);
}
