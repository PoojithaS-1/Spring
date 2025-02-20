package com.xworkz.airplaneapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor@NoArgsConstructor
@ToString
@Entity
@NamedQuery(name = "getAllData",query = "select c from AirplaneEntity c")
@NamedQuery(name = "getByModel",query = "select c from AirplaneEntity c where c.airplaneModel=:airplaneModel")
@NamedQuery(name = "getByNoOfSeats",query = "select c from AirplaneEntity c where c.noOfSeats=:noOfSeats")
@NamedQuery(name = "updateByModel",query = "update AirplaneEntity c set c.noOfSeats=:noOfSeats where c.airplaneModel=:airplaneModel")
@NamedQuery(name = "updateById",query = "update AirplaneEntity c set c.noOfSeats=:noOfSeats where c.airplaneId=:airplaneId")
@NamedQuery(name = "deleteById", query = "DELETE FROM AirplaneEntity c WHERE c.airplaneId = :airplaneId")
@Table(name = "airplane_info")
public class AirplaneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer airplaneId;
    private String airplaneModel;
    private Integer noOfSeats;
    private Long totalPassengers;
}
