package com.xworkz.formapp.dto;
import lombok.Data;

@Data
public class JobApplyDto {
    private Integer id;
    private String fullName;
    private String emailId;
    private Long mobileNumber;
    private String address;
    private String city;
    private String state;
    private Integer pinCode;
    private String educationalQualification;
    private String workExperience;
    private String skills;
}
