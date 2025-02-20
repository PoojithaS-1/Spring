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
        bankDto.setBankName("Axis");
        bankDto.setNoOfBranches(502);
        bankDto.setTotalDeposits(2367996l);
        bankService.validateAndSave(bankDto);
        bankService.getById(1);

        bankService.getByName("Axis");

        bankService.deleteById(3);

        bankService.updateByName("IOB",101);

        bankService.updateById(2,299);

        bankService.getByNoOfBranches(299);

        bankService.getAllData();
    }
}
