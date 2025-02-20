package com.xworkz.schoolapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "getAllData",query = "select c from SchoolEntity c")
@NamedQuery(name = "getByName",query = "select c from SchoolEntity c where c.schoolName=:schoolName")
@NamedQuery(name = "getByNoOfClassrooms",query = "select c from SchoolEntity c where c.noOfClassrooms=:noOfClassrooms")
@NamedQuery(name = "updateByName",query = "update SchoolEntity c set c.noOfClassrooms=:noOfClassrooms where c.schoolName=:schoolName")
@NamedQuery(name = "updateById",query = "update SchoolEntity c set c.noOfClassrooms=:noOfClassrooms where c.schoolId=:schoolId")
@NamedQuery(name = "deleteById", query = "DELETE FROM SchoolEntity c WHERE c.schoolId = :schoolId")
@ToString
@Table(name = "school_info")
public class SchoolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schoolId;
    private String schoolName;
    private Integer noOfClassrooms;
    private Long studentsEnrolled;
}
