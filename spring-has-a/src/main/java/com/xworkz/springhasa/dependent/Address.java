package com.xworkz.springhasa.dependent;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class Address {
    @Value("1")
    private Integer doorNo;
    @Value("Bhadravati")
    private String city;
    @Value("Karnataka")
    private String state;
}
