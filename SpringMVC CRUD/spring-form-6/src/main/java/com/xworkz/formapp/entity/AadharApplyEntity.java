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

@Table(name = "aadhar")
@NamedQuery(name = "getAllApplicantInfo",query = "select a from AadharApplyEntity a ")
@NamedQuery(name = "deleteById" , query = "delete from AadharApplyEntity ent where ent.id=:id")
//@NamedQuery(name = "getApplicantById" , query = "select ent from AadharApplyEntity ent where ent.id=:id")

@ToString
public class AadharApplyEntity {
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
    private String fatherName;
    private String motherName;
}
