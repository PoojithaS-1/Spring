package com.xworkz.formapp.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "visa")
@NamedQuery(name = "getAllApplicantInfo",query = "select v from VisaApplyEntity v")
@NamedQuery(name = "deleteById" , query = "delete from VisaApplyEntity ent where ent.id=:id")
//@NamedQuery(name = "getApplicantById" , query = "select ent from VisaApplyEntity ent where ent.id=:id")

@ToString
public class VisaApplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

