package com.xworkz.patientapp.service;

import com.xworkz.patientapp.dto.PatientDto;
import com.xworkz.patientapp.entity.PatientEntity;
import com.xworkz.patientapp.repository.PatientRepo;
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
public class PatientServiceImpl implements PatientService{
@Autowired
    PatientRepo patientRepo;
    @Override
    public Boolean validateAndSave(PatientDto patientDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<PatientDto>> validate = validator.validate(patientDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            PatientEntity patientEntity = new PatientEntity();
            try {
                BeanUtils.copyProperties(patientEntity, patientDto);
                System.out.println(patientEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            patientRepo.save(patientEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}