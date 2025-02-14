package com.xworkz.countryapp.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "country_details")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;
    private String countryName;
    private Integer noOfStates;
    private Long population;

}
