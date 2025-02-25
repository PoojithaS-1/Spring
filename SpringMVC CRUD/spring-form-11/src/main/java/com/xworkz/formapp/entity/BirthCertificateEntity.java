package com.xworkz.formapp.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "birthCertificate")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "deleteById" , query = "delete from BirthCertificateEntity ent where ent.id=:id")
//@NamedQuery(name = "getApplicantById" , query = "select ent from BirthCertificateEntity ent where ent.id=:id")
@NamedQuery(name = "getAllApplicantInfo",query = "select c from BirthCertificateEntity c")

@ToString

public class BirthCertificateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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