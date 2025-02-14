package com.xworkz.dishapp.service;

import com.xworkz.dishapp.dto.DishDto;
import com.xworkz.dishapp.entity.DishEntity;
import com.xworkz.dishapp.repository.DishRepo;
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
public class DishServiceImpl implements DishService{
    @Autowired
    DishRepo dishRepo;
    @Override
    public Boolean validateAndSave(DishDto dishDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<DishDto>> validate = validator.validate(dishDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            DishEntity dishEntity = new DishEntity();
            try {
                BeanUtils.copyProperties(dishEntity, dishDto);
                System.out.println(dishEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            dishRepo.save(dishEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}