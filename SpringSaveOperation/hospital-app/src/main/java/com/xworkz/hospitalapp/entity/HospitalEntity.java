package com.xworkz.hospitalapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "hospital_info")
public class HospitalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hospitalId;
    private String hospitalName;
    private Integer noOfBeds;
    private Long patientsServed;
}
