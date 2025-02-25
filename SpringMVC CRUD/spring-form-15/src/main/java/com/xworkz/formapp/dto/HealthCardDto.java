package com.xworkz.formapp.dto;
import lombok.Data;

@Data
public class HealthCardDto {
    private Integer id;
    private String fullName;
    private String dob;
    private String emailId;
    private Long mobileNumber;
    private String address;
    private String city;
    private String state;
    private Integer pinCode;
    private Long familyIncome;
}
