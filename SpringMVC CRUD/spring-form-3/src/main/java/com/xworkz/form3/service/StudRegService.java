package com.xworkz.form3.service;

import com.xworkz.form3.dto.StudRegDto;

import java.util.List;

public interface StudRegService {
    Boolean validateAndSave(StudRegDto studRegDto);

    List<StudRegDto> getAllStudInfo();

    void deleteById(int id);
}
