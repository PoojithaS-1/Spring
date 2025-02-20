package com.xworkz.bankapp.repository;

import com.xworkz.bankapp.entity.BankEntity;

import java.util.List;

public interface BankRepo {

    Boolean save(BankEntity bankEntity);
    BankEntity getById(Integer bankId);

    BankEntity getByNoOfBranches(Integer noOfBranches);

    BankEntity getByName(String bankName);

    Integer updateByName(String bankName, Integer noOfBranches);

    Integer updateById(Integer bankId, Integer noOfBranches);

    Integer deleteById(Integer bankId);

    List<BankEntity> getAllData();
}

