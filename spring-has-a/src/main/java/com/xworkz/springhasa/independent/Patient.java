package com.xworkz.springhasa.independent;

import com.xworkz.springhasa.dependent.Address;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Component
public class Patient {
    @Value("1")
    private Integer patientId;
    @Value("Usha")
    private String name;
    @Value("45")
    private String age;

    @Autowired
    private Address address;
}
