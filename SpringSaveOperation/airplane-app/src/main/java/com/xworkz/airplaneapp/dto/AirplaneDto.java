package com.xworkz.airplaneapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor@AllArgsConstructor
public class AirplaneDto {
    private Integer airplaneId;
    private String airplaneModel;
    private Integer noOfSeats;
    private Long totalPassengers;
}
