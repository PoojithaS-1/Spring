package com.xworkz.form3.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "stud_info")
@NamedQuery(name = "getAllStudInfo",query = "select s from StudRegEntity s")
@NamedQuery(name = "deleteById" , query = "delete from StudRegEntity ent where ent.studId=:studId")
//@NamedQuery(name = "getStudById" , query = "select ent from StudRegEntity ent where ent.studId=:studId")

@ToString
public class StudRegEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studId;
    private String fullName;
    private String dob;
    private String emailId;
    private Long mobileNumber;
    private String courseName;
    private String semester;
    private String collegeName;
}
