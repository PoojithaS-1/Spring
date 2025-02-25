package com.xworkz.userapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString

public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String emailId;
    private Long phoneNumber;
}
