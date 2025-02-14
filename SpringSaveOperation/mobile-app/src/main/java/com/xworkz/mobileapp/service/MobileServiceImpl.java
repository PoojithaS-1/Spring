package com.xworkz.mobileapp.service;

import com.xworkz.mobileapp.dto.MobileDto;
import com.xworkz.mobileapp.entity.MobileEntity;
import com.xworkz.mobileapp.repository.MobileRepo;
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
public class MobileServiceImpl implements MobileService{
@Autowired
    MobileRepo mobileRepo;
    @Override
    public Boolean validateAndSave(MobileDto mobileDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<MobileDto>> validate = validator.validate(mobileDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            MobileEntity mobileEntity = new MobileEntity();
            try {
                BeanUtils.copyProperties(mobileEntity, mobileDto);
                System.out.println(mobileEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            mobileRepo.save(mobileEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}
