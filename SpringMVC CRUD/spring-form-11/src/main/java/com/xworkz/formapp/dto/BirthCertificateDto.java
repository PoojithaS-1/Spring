package com.xworkz.formapp.dto;
import lombok.Data;

@Data
public class BirthCertificateDto {
    private Integer id;
    private String childName;
    private String dob;
    private String placeOfBirth;
    private String fatherName;
    private String motherName;
    private String address;
    private String city;
    private String state;
    private Integer pinCode;
}