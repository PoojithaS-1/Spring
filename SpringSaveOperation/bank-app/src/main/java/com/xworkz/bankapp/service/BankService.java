package com.xworkz.bankapp.service;

import com.xworkz.bankapp.dto.BankDto;

public interface BankService {
    Boolean validateAndSave(BankDto bankDto);
}
