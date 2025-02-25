package com.xworkz.form3.repository;

import com.xworkz.form3.entity.StudRegEntity;

import java.util.List;

public interface StudRegRepository {
    Boolean save(StudRegEntity studRegEntity);

    List<StudRegEntity> getAllStudInfo();

    void deleteById(int id);
}
