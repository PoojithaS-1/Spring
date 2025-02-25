package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.RationCardDto;

import java.util.List;

public interface RationCardService {
    Boolean validateAndSave(RationCardDto rationCardDto);

    List<RationCardDto> getAllApplicantInfo();

    void deleteById(int id);
}
