package com.xworkz.husband.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor@AllArgsConstructor
@ToString
public class HusbandDto {
    private Integer slNo;
    private String name;

    private  Integer age;

    private String occupation;
}
