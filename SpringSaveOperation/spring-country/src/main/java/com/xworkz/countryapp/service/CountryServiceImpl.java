package com.xworkz.countryapp.service;

import com.xworkz.countryapp.dto.CountryDto;
import com.xworkz.countryapp.entity.CountryEntity;
import com.xworkz.countryapp.repository.CountryRepository;
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
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;
    @Override
    public Boolean validateAndSave(CountryDto countryDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CountryDto>> validate = validator.validate(countryDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            CountryEntity countryEntity = new CountryEntity();
            try {
                BeanUtils.copyProperties(countryEntity, countryDto);
                System.out.println(countryEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            countryRepository.save(countryEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}
