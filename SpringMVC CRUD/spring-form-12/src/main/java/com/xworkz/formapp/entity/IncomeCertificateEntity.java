package com.xworkz.formapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "incomeCertificate")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQuery(name="getAllApplicantInfo",query = "select i from IncomeCertificateEntity i ")
@NamedQuery(name = "deleteById" , query = "delete from IncomeCertificateEntity ent where ent.id=:id")
//@NamedQuery(name = "getApplicantById" , query = "select ent from IncomeCertificateEntity ent where ent.id=:id")

public class IncomeCertificateEntity {

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
    private String occupation;
    private Long annualIncome;
}
