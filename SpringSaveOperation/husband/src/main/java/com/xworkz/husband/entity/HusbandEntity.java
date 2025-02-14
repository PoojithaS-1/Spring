package com.xworkz.husband.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor@ToString@AllArgsConstructor
@Table(name = "husbandInfo")
@Entity
public class HusbandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer slNo;
    private String name;

    private  Integer age;

    private String occupation;
}
