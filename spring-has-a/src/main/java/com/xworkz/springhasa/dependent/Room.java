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
public class Room {

    @Value("Bedroom")
    private String type;

    @Value("AC")
    private String cooling;

    @Value("Attached Bathroom")
    private String bathroom;
}
