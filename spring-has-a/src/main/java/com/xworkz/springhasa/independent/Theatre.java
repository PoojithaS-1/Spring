package com.xworkz.springhasa.independent;

import com.xworkz.springhasa.dependent.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@ToString
public class Theatre {

    @Value("PVR")
    private String name;

    @Value("Multiplex")
    private String type;

    @Value("AC")
    private String amenities;

    @Autowired
    private Movie movie;
}
