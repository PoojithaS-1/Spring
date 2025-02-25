package com.xworkz.edutechapp.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "edutech")
@NamedQuery(name = "getAllTraineeInfo",query = "select e from EduTechEntity e ")
@NamedQuery(name = "deleteById" , query = "delete from EduTechEntity ent where ent.id=:id")
//@NamedQuery(name = "getTraineeById",query = "select ent from EduTechEntity ent where ent.id=:id ")
@ToString
public class EduTechEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private Long contactNo;
    private String course;
    private String sem;
    private String collegeName;
    private Integer yearOfStudy;
}

