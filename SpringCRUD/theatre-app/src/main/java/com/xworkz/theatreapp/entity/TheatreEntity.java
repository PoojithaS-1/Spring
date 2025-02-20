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

@NamedQuery(name = "getAllData",query = "select theatre from TheatreEntity theatre")
@NamedQuery(name = "getByName",query = "select theatre from TheatreEntity theatre where theatre.name=:name")
@NamedQuery(name = "getByAmenities",query = "select theatre from TheatreEntity theatre where theatre.amenities=:amenities")
@NamedQuery(name = "updateByName",query = "update TheatreEntity theatre set theatre.amenities=:amenities where theatre.name=:name")
@NamedQuery(name = "updateById",query = "update TheatreEntity theatre set theatre.amenities=:amenities where theatre.id=:id")
@NamedQuery(name = "deleteById", query = "DELETE FROM TheatreEntity theatre WHERE theatre.id = :id")

@Table(name = "theatre_info")
public class TheatreEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private  Integer id;
    private String name;

    private String type;

    private String amenities;
}

