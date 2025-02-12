package com.xworkz.springhasa.independent;

import com.xworkz.springhasa.dependent.Stand;
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
public class Tv {

    @Value("Sony")
    private String brand;

    @Value("4K")
    private String resolution;

    @Value("55 inches")
    private String size;

    @Autowired
    private Stand stand;
}
