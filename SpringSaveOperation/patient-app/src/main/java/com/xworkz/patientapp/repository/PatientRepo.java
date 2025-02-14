package com.xworkz.patientapp.repository;

import com.xworkz.patientapp.entity.PatientEntity;

public interface PatientRepo {
    Boolean save(PatientEntity patientEntity);
}
