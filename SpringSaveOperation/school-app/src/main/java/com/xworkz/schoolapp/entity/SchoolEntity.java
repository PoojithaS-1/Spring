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
