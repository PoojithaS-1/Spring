package com.xworkz.springhasa.independent;

import com.xworkz.springhasa.dependent.HardDisk;
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
public class Laptop {

    @Value("Dell")
    private String brand;

    @Value("Inspiron")
    private String model;

    @Value("16GB")
    private String ram;

    @Autowired
    private HardDisk harddisk;
}

