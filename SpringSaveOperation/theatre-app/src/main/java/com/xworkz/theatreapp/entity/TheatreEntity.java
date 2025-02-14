package com.xworkz.theatreapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "theatre_info")
public class TheatreEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private  Integer id;
    private String name;

    private String type;

    private String amenities;
}

