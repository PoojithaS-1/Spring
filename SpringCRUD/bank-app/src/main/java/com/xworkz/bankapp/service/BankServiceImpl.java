package com.xworkz.bankapp.service;

import com.xworkz.bankapp.dto.BankDto;
import com.xworkz.bankapp.entity.BankEntity;
import com.xworkz.bankapp.repository.BankRepo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class BankServiceImpl implements BankService{
   @Autowired
    BankRepo bankRepo;

    @Override
    public Boolean validateAndSave(BankDto bankDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<BankDto>> validate = validator.validate(bankDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            BankEntity bankEntity = new BankEntity();
            try {
                BeanUtils.copyProperties(bankEntity, bankDto);
                System.out.println(bankEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            bankRepo.save(bankEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public BankEntity getById(Integer bankId) {
        BankEntity bankEntity = bankRepo.getById(bankId);
        if (bankEntity != null) {
            System.out.println(" id found\n" + bankEntity);
        }
        else {
            System.out.println(" id not found");
        }
        return bankEntity;    }

    @Override
    public BankEntity getByNoOfBranches(Integer noOfBranches) {
        BankEntity bankEntity = bankRepo.getByNoOfBranches( noOfBranches);
        if (bankEntity != null) {
            System.out.println("noOfBranches found\n" + bankEntity);
        }
        else {
            System.out.println("noOfBranches not found");
        }
        return bankEntity;    }

    @Override
    public BankEntity getByName(String bankName) {
        BankEntity bankEntity = bankRepo.getByName(bankName);
        if (bankEntity != null) {
            System.out.println("Bank name found\n" + bankEntity);
        }
        else {
            System.out.println("Bank name not found");
        }
        return bankEntity;

    }

    @Override
    public Integer updateByName(String bankName, Integer noOfBranches) {
        int rows=bankRepo.updateByName(bankName,noOfBranches);
        if (rows>0){
            System.out.println("noOfBranches is updated");
        }else {
            System.out.println("noOfBranches not updated");
        }return 0;    }

    @Override
    public Integer updateById(Integer bankId, Integer noOfBranches) {
        int rows=bankRepo.updateById(bankId, noOfBranches);
        if (rows>0){
            System.out.println("noOfBranches is updated");
        }else {
            System.out.println("noOfBranches not updated");
        }return 0;
    }

    @Override
    public Integer deleteById(Integer bankId) {
        int rows = bankRepo.deleteById(bankId);
        if (rows > 0) {
            System.out.println("bank with ID " + bankId + " is deleted");
        } else {
            System.out.println("bank with ID " + bankId + " not found or not deleted");
        }
        return rows;
    }

    @Override
    public List<BankDto> getAllData() {
        List<BankEntity> entities=bankRepo.getAllData();
        List<BankDto> bankDtos =new ArrayList<>();
        if (entities != null) {
            for (BankEntity entity : entities) {
                BankDto dto = new BankDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(bankDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                bankDtos.add(dto);
            }
        }
        return bankDtos;    }
}