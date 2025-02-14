package com.xworkz.houseapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HouseDto {
    private Integer houseNo;
    private String type;

    private String floors;
    private String garden;
}
