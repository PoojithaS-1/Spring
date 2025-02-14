package com.xworkz.houseapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "house_info")
public class HouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer houseNo;
    private String type;

    private String floors;
    private String garden;

}
