package com.xworkz.bankapp;

import com.xworkz.bankapp.config.BankConfig;
import com.xworkz.bankapp.dto.BankDto;
import com.xworkz.bankapp.service.BankService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BankRunner {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(BankConfig.class);
        BankService bankService = ac.getBean(BankService.class);
        BankDto bankDto=new BankDto();
        bankDto.setBankName("IOB");
        bankDto.setNoOfBranches(552);
        bankDto.setTotalDeposits(23456786l);
        bankService.validateAndSave(bankDto);

    }
}
