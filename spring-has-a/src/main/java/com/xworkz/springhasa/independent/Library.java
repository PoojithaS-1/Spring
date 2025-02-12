package com.xworkz.springhasa.independent;

import com.xworkz.springhasa.dependent.Book;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
@ToString
@NoArgsConstructor
public class Library {
    @Value("1")
    private Integer libId;
    @Value("Vinayaka")
    private String libName;
    @Value("4500")
    private Integer noOfBooks;

    @Autowired
    private Book book;
}
