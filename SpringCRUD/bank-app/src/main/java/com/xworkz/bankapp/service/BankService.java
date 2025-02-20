package com.xworkz.bankapp.service;

import com.xworkz.bankapp.dto.BankDto;
import com.xworkz.bankapp.entity.BankEntity;

import java.util.List;

public interface BankService {
    Boolean validateAndSave(BankDto bankDto);
    BankEntity getById(Integer bankId);

    BankEntity getByNoOfBranches(Integer noOfBranches);

    BankEntity getByName(String bankName);

    Integer updateByName(String bankName, Integer noOfBranches);

    Integer updateById(Integer bankId, Integer noOfBranches);

    Integer deleteById(Integer bankId);

    List<BankDto> getAllData();
}
