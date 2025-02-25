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
@Table(name = "passport")
@NamedQuery(name = "getAllApplicantInfo",query = "select p from PassportRegEntity p")
@NamedQuery(name = "deleteById" , query = "delete from PassportRegEntity ent where ent.id=:id")
//@NamedQuery(name = "getApplicantById" , query = "select ent from PassportRegEntity ent where ent.id=:id")

@ToString
public class PassportRegEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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