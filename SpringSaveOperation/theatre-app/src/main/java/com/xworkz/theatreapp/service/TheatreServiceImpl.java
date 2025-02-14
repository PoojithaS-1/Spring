package com.xworkz.theatreapp.service;

import com.xworkz.theatreapp.dto.TheatreDto;
import com.xworkz.theatreapp.entity.TheatreEntity;
import com.xworkz.theatreapp.repository.TheatreRepo;
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
public class TheatreServiceImpl implements TheatreService{
@Autowired
    TheatreRepo theatreRepo;
    @Override
    public Boolean validateAndSave(TheatreDto theatreDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<TheatreDto>> validate = validator.validate(theatreDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            TheatreEntity theatreEntity = new TheatreEntity();
            try {
                BeanUtils.copyProperties(theatreEntity, theatreDto);
                System.out.println(theatreEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            theatreRepo.save(theatreEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}

