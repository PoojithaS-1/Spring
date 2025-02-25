package com.xworkz.formapp.dto;
import lombok.Data;

@Data
public class PassportRegDto {
    private Integer id;
    private String applicantName;
    private String dob;
    private String emailId;
    private Long mobileNumber;
    private String address;
    private String city;
    private String state;
    private Integer pinCode;
}
