package com.xworkz.hospitalapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor@NoArgsConstructor@ToString
public class HospitalDto {
    private Integer hospitalId;
    private String hospitalName;
    private Integer noOfBeds;
    private Long patientsServed;
}
