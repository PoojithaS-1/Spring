package com.xworkz.form3.dto;
import lombok.Data;

@Data
public class StudRegDto {
    private Integer studId;
    private String fullName;
    private String dob;
    private String emailId;
    private Long mobileNumber;
    private String courseName;
    private String semester;
    private String collegeName;
}