package com.xworkz.dishapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class DishDto {
    private Integer slNo;
    private String name;
    private String cuisine;
    private String taste;
}
