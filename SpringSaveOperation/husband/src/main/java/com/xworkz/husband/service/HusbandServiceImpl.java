package com.xworkz.husband.service;

import com.xworkz.husband.dto.HusbandDto;
import com.xworkz.husband.entity.HusbandEntity;
import com.xworkz.husband.repository.HusbandRepo;
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
public class HusbandServiceImpl implements HusbandService{
    @Autowired
    HusbandRepo husbandRepo;
    @Override
    public Boolean validateAndSave(HusbandDto husbandDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<HusbandDto>> validate = validator.validate(husbandDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            HusbandEntity husbandEntity = new HusbandEntity();
            try {
                BeanUtils.copyProperties(husbandEntity, husbandDto);
                System.out.println(husbandEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            husbandRepo.save(husbandEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}
