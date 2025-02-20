package com.xworkz.mobileapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MobileDto {
    private String brand;

    private  Integer id;
    private String model;


    private String storage;
}
