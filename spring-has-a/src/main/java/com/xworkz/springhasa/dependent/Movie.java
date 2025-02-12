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
public class Movie {

    @Value("KGF Chapter 2")
    private String title;

    @Value("Action")
    private String genre;

    @Value("Kannada")
    private String language;
}