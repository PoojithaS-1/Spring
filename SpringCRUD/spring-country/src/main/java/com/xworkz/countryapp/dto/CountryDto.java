package com.xworkz.countryapp.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {

    private Integer countryId;
    private String countryName;
    private Integer noOfStates;
    private Long population;
}
