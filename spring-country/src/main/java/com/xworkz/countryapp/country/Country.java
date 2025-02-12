package com.xworkz.countryapp.country;

import com.xworkz.countryapp.politician.Politician;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Component("oldCountry")
public class Country {
    @Value("1") // Used for assigning values to number & string dtype( byte,short,int,long,double & String)
    private Integer countryId;
    @Value("India")
    private String countryName;
    @Value("28")
    private int noOfStates;
    @Value("142000000") // If we add 'L' (e.g., 142000000L), it causes a NumberFormatException for input string
    private long population;

    // @Value("1,'Thejaswi Surya'") // @Value does not support complex objects like custom types.
    // This will cause an error: "No matching editors or conversion strategy found."

    // For custom object dependencies, use @Autowired instead of @Value.
    @Autowired // Establishes a "has-a" relationship (Country depends on Politician).
    private Politician politician;
}
