package com.xworkz.laptopapp.service;

import com.xworkz.laptopapp.dto.LaptopDto;
import com.xworkz.laptopapp.entity.LaptopEntity;
import com.xworkz.laptopapp.repository.LaptopRepo;
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
public class LaptopServiceImpl implements LaptopService{
@Autowired
    LaptopRepo laptopRepo;
    @Override
    public Boolean validateAndSave(LaptopDto laptopDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<LaptopDto>> validate = validator.validate(laptopDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            LaptopEntity laptopEntity = new LaptopEntity();
            try {
                BeanUtils.copyProperties(laptopEntity, laptopDto);
                System.out.println(laptopEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            laptopRepo.save(laptopEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}