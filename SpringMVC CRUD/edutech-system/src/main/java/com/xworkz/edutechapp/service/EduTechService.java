package com.xworkz.edutechapp.service;

import com.xworkz.edutechapp.dto.EduTechDto;

import java.util.List;

public interface EduTechService {
    Boolean validateAndSave(EduTechDto eduTechDto);

    List<EduTechDto> getAllTraineeInfo();
    void deleteById(Integer id);
}
