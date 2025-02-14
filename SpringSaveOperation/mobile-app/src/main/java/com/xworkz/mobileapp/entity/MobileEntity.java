package com.xworkz.mobileapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "mobile_info")
public class MobileEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  Integer id;
    private String brand;



    private String model;


    private String storage;
}
