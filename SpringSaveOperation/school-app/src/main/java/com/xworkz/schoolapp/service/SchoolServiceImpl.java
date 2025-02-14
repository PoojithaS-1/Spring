package com.xworkz.schoolapp.service;

import com.xworkz.schoolapp.dto.SchoolDto;
import com.xworkz.schoolapp.entity.SchoolEntity;
import com.xworkz.schoolapp.repository.SchoolRepo;
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
public class SchoolServiceImpl implements SchoolService{
@Autowired
    SchoolRepo schoolRepo;
    @Override
    public Boolean validateAndSave(SchoolDto schoolDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<SchoolDto>> validate = validator.validate(schoolDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            SchoolEntity schoolEntity = new SchoolEntity();
            try {
                BeanUtils.copyProperties(schoolEntity, schoolDto);
                System.out.println(schoolEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            schoolRepo.save(schoolEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}
