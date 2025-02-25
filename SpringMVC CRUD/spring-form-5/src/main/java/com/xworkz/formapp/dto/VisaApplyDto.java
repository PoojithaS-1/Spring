package com.xworkz.formapp.dto;

import lombok.Data;

    @Data
    public class VisaApplyDto {
        private Integer id;
        private String applicantName;
        private String passportNumber;
        private String dob;
        private String emailId;
        private Long mobileNumber;
        private String address;
        private String city;
        private String state;
        private Integer pinCode;
        private String visaType;
        private String travelDates;
    }


