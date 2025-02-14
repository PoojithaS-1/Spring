package com.xworkz.laptopapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LaptopDto {
    private  Integer id;
    private String brand;

    private String model;

    private String ram;
}
