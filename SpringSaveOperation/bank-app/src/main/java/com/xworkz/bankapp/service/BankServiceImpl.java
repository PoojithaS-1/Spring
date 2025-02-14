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
}