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
@NamedQuery(name = "getAllData",query = "select c from RestaurantEntity c")
@NamedQuery(name = "getByName",query = "select c from RestaurantEntity c where c.restaurantName=:restaurantName")
@NamedQuery(name = "getByNoOfTables",query = "select c from RestaurantEntity c where c.noOfTables=:noOfTables")
@NamedQuery(name = "updateByName",query = "update RestaurantEntity c set c.noOfTables=:noOfTables where c.restaurantName=:restaurantName")
@NamedQuery(name = "updateById",query = "update RestaurantEntity c set c.noOfTables=:noOfTables where c.restaurantId=:restaurantId")
@NamedQuery(name = "deleteById", query = "DELETE FROM RestaurantEntity c WHERE c.restaurantId = :restaurantId")

@Table(name = "restaurant_info")
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restaurantId;
    private String restaurantName;
    private Integer noOfTables;
    private Long revenue;
}
