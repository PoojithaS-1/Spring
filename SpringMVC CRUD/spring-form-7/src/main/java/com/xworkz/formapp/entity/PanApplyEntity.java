package com.xworkz.formapp.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pan")
@NamedQuery(name = "getAllApplicantInfo",query = "select p from PanApplyEntity p")
@NamedQuery(name = "deleteById" , query = "delete from PanApplyEntity ent where ent.id=:id")
//@NamedQuery(name = "getApplicantById" , query = "select ent from PanApplyEntity ent where ent.id=:id")

@ToString

public class PanApplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String fatherName;
    private String motherName;
    private String dob;
    private String emailId;
    private Long mobileNumber;
    private String address;
    private String city;
    private String state;
    private Integer pinCode;
}
