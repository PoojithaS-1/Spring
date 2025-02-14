package com.xworkz.schoolapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor@AllArgsConstructor@ToString
public class SchoolDto {
    private Integer schoolId;
    private String schoolName;
    private Integer noOfClassrooms;
    private Long studentsEnrolled;
}
