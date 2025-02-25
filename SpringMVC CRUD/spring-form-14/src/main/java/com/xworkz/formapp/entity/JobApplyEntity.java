package com.xworkz.formapp.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@Table(name = "jobApply")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "getAllApplicantInfo",query = "select j from JobApplyEntity j ")
@NamedQuery(name = "deleteById" , query = "delete from JobApplyEntity ent where ent.id=:id")
//@NamedQuery(name = "getApplicantById" , query = "select ent from JobApplyEntity ent where ent.id=:id")


public class JobApplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String emailId;
    private Long mobileNumber;
    private String address;
    private String city;
    private String state;
    private Integer pinCode;
    private String educationalQualification;
    private String workExperience;
    private String skills;
}