package com.xworkz.userapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@NamedQuery(name = "getAllUserInfo",query = "select usr from UserEntity usr")
@NamedQuery(name = "deleteById" , query = "delete from UserEntity usr where usr.id=:id")
@Table(name = "user")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String emailId;
    private Long phoneNumber;
}
