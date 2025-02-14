package com.xworkz.airplaneapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor@NoArgsConstructor
@ToString
@Entity@Table(name = "airplane_info")
public class AirplaneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer airplaneId;
    private String airplaneModel;
    private Integer noOfSeats;
    private Long totalPassengers;
}
