package com.xworkz.formapp.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "scholarship")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQuery(name = "getAllApplicantInfo",query = "select s from ScholarshipEntity s")
@NamedQuery(name = "deleteById" , query = "delete from ScholarshipEntity ent where ent.id=:id")
//@NamedQuery(name = "getApplicantById" , query = "select ent from ScholarshipEntity ent where ent.id=:id")


public class ScholarshipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String dob;
    private String emailId;
    private Long mobileNumber;
    private String address;
    private String city;
    private String state;
    private Integer pinCode;
    private String educationalQualification;
    private Long annualFamilyIncome;
}
