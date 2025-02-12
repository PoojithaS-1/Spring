package com.xworkz.springhasa.independent;

import com.xworkz.springhasa.dependent.Wife;
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
public class Husband {
    @Value("Srinivas")
    private String name;
    @Value("55")
    private  Integer age;
    @Value("Farmer")
    private String occupation;

    @Autowired
    private Wife wife;
}
