package com.xworkz.airplaneapp.service;

import com.xworkz.airplaneapp.dto.AirplaneDto;
import com.xworkz.airplaneapp.entity.AirplaneEntity;
import com.xworkz.airplaneapp.repository.AirplaneRepo;
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
public class AirplaneServiceImpl implements AirplaneService{
@Autowired
    AirplaneRepo airplaneRepo;
    @Override
    public Boolean validateAndSave(AirplaneDto airplaneDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<AirplaneDto>> validate = validator.validate(airplaneDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            AirplaneEntity airplaneEntity = new AirplaneEntity();
            try {
                BeanUtils.copyProperties(airplaneEntity, airplaneDto);
                System.out.println(airplaneEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            airplaneRepo.save(airplaneEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}