package com.xworkz.libapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor@ToString
@Table(name = "lib_info")
@Entity
public class LibEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer libId;

    private String libName;

    private Integer noOfBooks;
}
