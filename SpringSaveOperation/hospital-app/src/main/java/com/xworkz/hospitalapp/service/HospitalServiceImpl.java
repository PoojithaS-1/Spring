package com.xworkz.hospitalapp.service;

import com.xworkz.hospitalapp.dto.HospitalDto;
import com.xworkz.hospitalapp.entity.HospitalEntity;
import com.xworkz.hospitalapp.repository.HospitalRepo;
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
public class HospitalServiceImpl implements HospitalService{
@Autowired
    HospitalRepo hospitalRepo;
    @Override
    public Boolean validateAndSave(HospitalDto hospitalDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<HospitalDto>> validate = validator.validate(hospitalDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            HospitalEntity hospitalEntity = new HospitalEntity();
            try {
                BeanUtils.copyProperties(hospitalEntity, hospitalDto);
                System.out.println(hospitalEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            hospitalRepo.save(hospitalEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}
