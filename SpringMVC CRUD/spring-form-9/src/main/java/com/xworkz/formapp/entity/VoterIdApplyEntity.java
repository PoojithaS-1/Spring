package com.xworkz.formapp.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "voterId")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "getAllApplicantInfo",query = "select v from VoterIdApplyEntity v ")
@NamedQuery(name = "deleteById" , query = "delete from VoterIdApplyEntity ent where ent.id=:id")
//@NamedQuery(name = "getApplicantById" , query = "select ent from VoterIdApplyEntity ent where ent.id=:id")

@ToString
public class VoterIdApplyEntity{

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
}
