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
@NamedQuery(name = "getAllData",query = "select mobile from MobileEntity mobile")
@NamedQuery(name = "getByBrand",query = "select mobile from MobileEntity mobile where mobile.brand=:brand")
@NamedQuery(name = "getByModel",query = "select mobile from MobileEntity mobile where mobile.model=:model")
@NamedQuery(name = "updateByBrand",query = "update MobileEntity mobile set mobile.model=:model where mobile.brand=:brand")
@NamedQuery(name = "updateById",query = "update MobileEntity mobile set mobile.model=:model where mobile.id=:id")
@NamedQuery(name = "deleteById", query = "DELETE FROM MobileEntity mobile WHERE mobile.id = :id")

@Table(name = "mobile_info")
public class MobileEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  Integer id;
    private String brand;

    private String model;


    private String storage;
}
