package com.xworkz.restaurantapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor@AllArgsConstructor
@ToString
public class RestaurantDto {
    private Integer restaurantId;
    private String restaurantName;
    private Integer noOfTables;
    private Long revenue;
}
