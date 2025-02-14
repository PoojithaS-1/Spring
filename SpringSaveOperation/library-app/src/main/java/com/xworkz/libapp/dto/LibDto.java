package com.xworkz.libapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor@ToString
public class LibDto {
    private Integer libId;

    private String libName;

    private Integer noOfBooks;
}
