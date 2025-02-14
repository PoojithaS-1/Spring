package com.xworkz.patientapp.service;

import com.xworkz.patientapp.dto.PatientDto;

public interface PatientService {
    Boolean validateAndSave(PatientDto patientDto);
}
