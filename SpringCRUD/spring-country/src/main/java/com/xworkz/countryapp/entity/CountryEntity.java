package com.xworkz.countryapp.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "getAllData",query = "select c from CountryEntity c")
@NamedQuery(name = "getByName",query = "select c from CountryEntity c where c.countryName=:countryName")
@NamedQuery(name = "getByNoOfStates",query = "select c from CountryEntity c where c.noOfStates=:noOfStates")
@NamedQuery(name = "updateByName",query = "update CountryEntity c set c.noOfStates=:noOfStates where c.countryName=:countryName")
@NamedQuery(name = "updateById",query = "update CountryEntity c set c.noOfStates=:noOfStates where c.countryId=:countryId")
@NamedQuery(name = "deleteById", query = "DELETE FROM CountryEntity c WHERE c.countryId = :countryId")

@Table(name = "country_details")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;
    private String countryName;
    private Integer noOfStates;
    private Long population;

}
