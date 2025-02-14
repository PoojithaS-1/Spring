package com.xworkz.houseapp.service;

import com.xworkz.houseapp.dto.HouseDto;
import com.xworkz.houseapp.entity.HouseEntity;
import com.xworkz.houseapp.repository.HouseRepo;
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
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseRepo houseRepo;
    @Override
    public Boolean validateAndSave(HouseDto houseDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<HouseDto>> validate = validator.validate(houseDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            HouseEntity houseEntity = new HouseEntity();
            try {
                BeanUtils.copyProperties(houseEntity, houseDto);
                System.out.println(houseEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            houseRepo.save(houseEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}
