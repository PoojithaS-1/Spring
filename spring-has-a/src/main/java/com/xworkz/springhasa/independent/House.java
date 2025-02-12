package com.xworkz.springhasa.independent;

import com.xworkz.springhasa.dependent.Room;
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
public class House {

    @Value("Bungalow")
    private String type;

    @Value("3 Floors")
    private String floors;

    @Value("Garden")
    private String garden;

    @Autowired
    private Room room;
}
