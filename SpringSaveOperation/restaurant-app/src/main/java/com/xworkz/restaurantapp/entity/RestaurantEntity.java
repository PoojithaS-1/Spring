package com.xworkz.restaurantapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor@ToString
@NoArgsConstructor
@Entity
@Table(name = "restaurant_info")
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restaurantId;
    private String restaurantName;
    private Integer noOfTables;
    private Long revenue;
}
