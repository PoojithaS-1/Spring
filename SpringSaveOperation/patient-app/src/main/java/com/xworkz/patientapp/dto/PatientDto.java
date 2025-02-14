package com.xworkz.patientapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PatientDto {
    private Integer patientId;

    private String name;

    private Integer age;
}
