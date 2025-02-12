package com.xworkz.springhasa.dependent;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@ToString
public class SimCard {

    @Value("Airtel")
    private String provider;

    @Value("9876543210")
    private String number;

    @Value("4G")
    private String network;
}
