package com.xworkz.laptopapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "laptop_info")
public class LaptopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String brand;

    private String model;

    private String ram;
}
