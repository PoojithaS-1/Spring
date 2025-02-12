package com.xworkz.springhasa.dependent;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@ToString
@Component
public class Book {
    @Value("1")
    private Integer bookId;
    @Value("Ramayana")
    private String  bookName;
    @Value("200.00")
    private Double price;

}
